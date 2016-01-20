<%@page import="Entities.TblTrailer"%>
<%@page import="java.util.List"%>

<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper">
    <div class="center margintop25 marginbot25">
        <% 
            Object tempLst = request.getSession().getAttribute("trailers");
            /**
             *  als de session verlopen is redirect ik naar de servlet om terug data op te halen
             */
            if (tempLst == null) {
                response.sendRedirect("TrailerServlet.jsp");
            } else {
                List<TblTrailer> lst = (List<TblTrailer>) tempLst;
                String path = null;
                String title = null;
                Object tempId = request.getParameter("id");
                if (tempId == null) {
                    path = lst.get(0).getUrl();
                    title = lst.get(0).getNaam();
                } else if (tempId != null) {
                    for (TblTrailer item : lst) {
                        if (String.valueOf(item.getId()).equals(tempId.toString())) {
                            path = item.getUrl();
                            title = item.getNaam();
                        }
                    }
                } else {
                    response.sendRedirect("infoPage.jsp");
                }
        %> 
        <h2 id="displBlock"><%= title %></h2>
        <iframe id="trailer" src="<%= path %>" frameborder="0" allowfullscreen></iframe>
        <ul class="itemWrapper padbot0">
        <%
            for (TblTrailer trailer : lst) { %>
            <li class="items trailerItems">   
                <a href="trailers.jsp?id=<%= trailer.getId() %>" class="itemText"><%= trailer.getNaam() %></a>
                <img class="trailerImage" src="<%= trailer.getImage() %>" />
            </li>
            <%  }    
        } %>
        </ul>
                
    </div>
</div>

<%@ include file="templates/Footer.jsp" %>