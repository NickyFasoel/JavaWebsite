package Servlets;

import EJBs.VertoningEJB;
import Entities.TblFilm;
import Entities.TblVertoning;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowInfoServlet extends HttpServlet {

    @EJB
    private VertoningEJB vertEJB;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tempId = request.getParameter("Id");
        if (tempId != null) {
            try {
                long id = Long.parseLong(tempId);
                List<TblFilm> lstFilms = (List<TblFilm>) request.getSession().getAttribute("films");
                for (TblFilm film : lstFilms) {
                    if (film.getId() == id) {
                        request.setAttribute("selectedFilm", film); 
                    }
                }
                List<TblVertoning> allVertoningen = vertEJB.getAllVertoningen(id);
                request.getSession().setAttribute("vertoningen", allVertoningen);
                
                RequestDispatcher rd = request.getRequestDispatcher("infoPage.jsp");
                rd.forward(request, response);
            } catch (NumberFormatException | ServletException | IOException ex) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
