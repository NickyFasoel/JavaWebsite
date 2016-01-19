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
            int started = 5;
            try {
                started = vertEJB.isStarted(speeluur);
            } catch (ParseException ex) {
                Logger.getLogger(PayServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (started != 5 && started < 0) {
                request.setAttribute("voorstellingError", "This show is already done/started.");
                rd = request.getRequestDispatcher("buyTickets.jsp");
                rd.forward(request, response);
            } else if (started != 5 && started >= 0){
                TblVertoning vert = vertEJB.isRoom(id, speeluur, speeldag);

                TblGebruiker user = (TblGebruiker) request.getSession().getAttribute("user");

                if (vert != null) {
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

            TblGebruiker user = (TblGebruiker) request.getSession().getAttribute("user");

            if (vert != null) {
                payEJB.pay(user, vert, Integer.parseInt(tickets));

                rd = request.getRequestDispatcher("paidPage.jsp");
                rd.forward(request, response);
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
