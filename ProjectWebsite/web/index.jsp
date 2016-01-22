<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.TblFilm"%>
<%@page import="Entities.TblFilm"%>
<%@page import="Servlets.StartServlet"%>

<%@ include file="templates/Header.jsp" %>

    <ul class="itemWrapper">

<%  // indien dat de sessie bvb verlopen is haal ik de films terug op
    // als ze nog in session zitten gebruik ik ze gwn terug
    Object objFilms = request.getSession().getAttribute("films");
    if (objFilms == null) {
        RequestDispatcher rd = request.getRequestDispatcher("StartServlet");
        rd.forward(request, response);
    } else { 
        List<TblFilm> lst = (List<TblFilm>) objFilms; 
        for (TblFilm f : lst) { %>
            <li class="items"> 
                <% // Hier moet ik het pad aanpassen Images => images, hoofdletter gevoelig
                   // Desktop is het met I en hier i => refactor hielp niet (naam veranderen)
                   // alle items (films) haal ik het pad en steek dit in een variable, 
                   // ditto met de id om deze door te geven als param
                   String temp = f.getImage(); 
                   String path = temp.substring(0, 1).toLowerCase() + temp.substring(1);
                %>
                <img class="itemImage" src="<%= path %>" />
                <a href="ShowInfoServlet?Id=<%= f.getId() %>" class="itemText"><%= f.getNaam() %></a>
            </li>
        <% } 
    } %>

    </ul>
    
<%@ include file="templates/Footer.jsp" %>