<%@page import="Entities.TblTrailer"%>
<%@page import="java.util.List"%>

<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper">
    <div class="center margintop25 marginbot25">
        <% 
            Object tempLst = request.getSession().getAttribute("trailers");
            /**
             *  als de session verlopen is redirect ik naar de servlet om terug de data op te halen
             *  anders blijf ik op deze pagina met parameter id "spelen" zolang mogelijk
             */
            if (tempLst == null) {
                response.sendRedirect("TrailerServlet.jsp");
            } else {
                List<TblTrailer> lst = (List<TblTrailer>) tempLst;
                String path = null;
                String title = null;
                Object tempId = request.getParameter("id");
                if (tempId == null) {
                    // start trailer en naam => home page ish
                    // ook als de url string veranderd
                    path = lst.get(0).getUrl();
                    title = lst.get(0).getNaam();
                } else if (tempId != null) {
                    for (TblTrailer item : lst) {
                        if (String.valueOf(item.getId()).equals(tempId.toString())) {
                            // veranderd het path en title afhankelijk van de param id
                            path = item.getUrl();
                            title = item.getNaam();
                        } 
                    }
                        // id = niet te vinden => return om errors te vermijden en redirect
                    if (path == null && title == null) {
                        response.sendRedirect("trailers.jsp"); 
                        return;
                    }
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