package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyTicketsServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Object objUser = request.getSession().getAttribute("user");
        // param opvragen uit url van vorige pagina
        // indien null (manipulatie) en geen user => loginpage
        String id = request.getParameter("Id");
        if (id == null && objUser == null) {
            request.setAttribute("logFirst", "You must login first before buying tickets.");
            RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
            rd.forward(request, response);
            
            // als de id ontbreekt en er is een user ingelogd => indexpage
        } else if (id == null && objUser != null) {
            RequestDispatcher rd = request.getRequestDispatcher("indexPage.jsp");
            rd.forward(request, response);
            
            // dubbele veilgheid anders kon ik ticket kopen door param mee te geven
        } else if (id != null && objUser != null){
            long longId = 0;
            try {
                // als de id geen getal is forward
                longId = Long.parseLong(id);
            } catch(Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
                rd.forward(request, response);
            }   
                // id = dus geparsed steek ik deze in attr vo buytickets page
            if (longId != 0) {
                request.setAttribute("id", longId);
                RequestDispatcher rd = request.getRequestDispatcher("buyTickets.jsp");
                rd.forward(request, response);
            } 
                // id niet null maar niet ingelogd => loginpage
        } else if (id != null && objUser == null){ 
            RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
            rd.forward(request, response);
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
