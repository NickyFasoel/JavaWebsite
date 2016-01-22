package Servlets;

import Entities.TblFilm;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowInfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // param ophalen van de geklikte a href en 
        // checken of de url niet aangepast is
        String tempId = request.getParameter("Id");
        if (tempId != null) {
            try {
                // indien aangepast en geen getal
                // proberen te parsen indien dit geen getal is of id bestaat niet
                // redirect ik naar de index page
                long id = Long.parseLong(tempId);
                // controleren of de id bestaat in list films
                List<TblFilm> lstFilms = (List<TblFilm>) request.getSession().getAttribute("films");
                for (TblFilm film : lstFilms) {
                    if (film.getId() == id) {
                        // match? in attribute steken voor te gebruiken in infoPage 
                        request.setAttribute("selectedFilm", film); 
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("infoPage.jsp");
                rd.forward(request, response);
            } catch (NumberFormatException | ServletException | IOException ex) {
                response.sendRedirect("index.jsp");
            }
        } else {
            // indien geen parameter te vinden door bvb manipulatie van url
            response.sendRedirect("index.jsp");
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
