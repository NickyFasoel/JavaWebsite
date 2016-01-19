<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.TblFilm"%>
<%@page import="Entities.TblFilm"%>
<%@page import="Servlets.StartServlet"%>

<%@ include file="templates/Header.jsp" %>

    <ul class="itemWrapper">

<%  
    if (request.getSession().getAttribute("films") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("StartServlet");
        rd.forward(request, response);
    } else { 
        List<TblFilm> lst = (List<TblFilm>)request.getSession().getAttribute("films"); 
        for (TblFilm f : lst) { %>
            <li class="items"> 
                <% String temp = f.getImage(); 
                   String path= temp.substring(0, 1).toLowerCase() + temp.substring(1);
                %>
                <img class="itemImage" src="<%= path %>" />
                
                <a href="ShowInfoServlet?Id=<%= f.getId() %>" class="itemText"><%= f.getNaam() %></a>
                
            </li>
        <% } 
    } %>

    </ul>
    
<%@ include file="templates/Footer.jsp" %>