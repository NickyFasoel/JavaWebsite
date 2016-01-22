package Servlets;

import EJBs.PayEJB;
import EJBs.VertoningEJB;
import Entities.TblGebruiker;
import Entities.TblVertoning;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayServlet extends HttpServlet {

    @EJB
    VertoningEJB vertEJB;
    @EJB
    PayEJB payEJB;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tempId = request.getParameter("film");
        long id = Long.parseLong(tempId);
        
        String speeluur = request.getParameter("speeluur");
        String speeldag = request.getParameter("speeldag");
        String tickets = request.getParameter("tickets");
        
        RequestDispatcher rd;
        if (new SimpleDateFormat("EEEE", Locale.UK).format(new Date()).equals(speeldag)) {
            // Moest initialized zijn dus: 42 is the answer to everything
            int started = 42;
            try { // kijken of deze al begonnen is gebruikt compareTo(date)
                  // returned -1 = verleden tijd
                  // 0 als het uur identiek is dus geen verschil in tijd
                  // 1 als het in de toekomst ligt
                started = vertEJB.isStarted(speeluur);
            } catch (ParseException ex) {
                Logger.getLogger(PayServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                // show is al begonnen
            if (started < 0) {
                request.setAttribute("voorstellingError", "This show is already done/started.");
                rd = request.getRequestDispatcher("buyTickets.jsp");
                rd.forward(request, response);
                
                // show moet nog beginnen of is nu pas begonnen
            } else if (started >= 0) {
                TblVertoning vert = vertEJB.isRoom(id, speeluur, speeldag);
                if (vert != null) {
                    // ingelogde gebruiker persisten
                    TblGebruiker user = (TblGebruiker) request.getSession().getAttribute("user");
                    payEJB.pay(user, vert, Integer.parseInt(tickets));

                    rd = request.getRequestDispatcher("paidPage.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("voorstellingError", "This show is full.");
                    rd = request.getRequestDispatcher("buyTickets.jsp");
                    rd.forward(request, response);
                }
            }
        } else {
            TblVertoning vert = vertEJB.isRoom(id, speeluur, speeldag);
            if (vert != null) {
                TblGebruiker user = (TblGebruiker) request.getSession().getAttribute("user");
                
                if (user == null) {
                    response.sendRedirect("index.jsp");
                    return;
                }
                payEJB.pay(user, vert, Integer.parseInt(tickets));
                /**
                 *  invalidate en sendredirect:
                 *  anders kan refresh opnieuw tickets "kopen" 
                 *  en kan de controle user == null voorkomen van nogeens tickets te kopen
                 *  normaal zou er een betaalpagina vd bank tussen zitten 
                 *  en kan dit zoiezo niet of minder tenminste minder kwaad omdat ze dan toch moeten betalen
                 */
                request.getSession().invalidate();
                response.sendRedirect("paidPage.jsp");
            } else {
                request.setAttribute("voorstellingError", "This show is full.");
                rd = request.getRequestDispatcher("buyTickets.jsp");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
