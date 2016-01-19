<%@page import="java.util.List"%>
<%@page import="Entities.TblVertoning"%>
<%@page import="Entities.TblFilm"%>

<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper">
    <div id="infoPageWrapper" class="center">
        
        <% 
            TblFilm film = (TblFilm) request.getAttribute("selectedFilm"); 
            String temp = film.getImage(); 
            String path= temp.substring(0, 1).toLowerCase() + temp.substring(1);
        %>

        <img id="selectedFilm" src="<%= path %>">
        
        <h2>Movie Days:</h2><br>
        <p>
            <%= film.getSpeeldagen() %>
        </p>
        
        <h2>Hours:</h2><br>
        <p>
            <%= film.getSpeeluren() %>       
            <%-- List<TblVertoning> vert = (List<TblVertoning>) request.getSession().getAttribute("vertoningen");
                for (TblVertoning v : vert) { %>
                <%= v.getSpeelUur() %>
            <%}--%>
        </p>
        
        <%  String pagina; // TODO: eerst in variabele steken voor te testen
            if (request.getSession().getAttribute("user") != null ) {
                pagina = "buyTickets.jsp?Id=" + String.valueOf(film.getId()); 
            } else {
                // Session omdat deze servlet paar keer wordt gebruikt
                request.getSession().setAttribute("logFirst", "You must login first before buying tickets.");
                pagina = "loginPage.jsp";
            }
        %>
        <a href=<%= pagina %> class="button" id="buyTicketsBtn">Buy Tickets</a>
        <h2 id="description">Description:</h2>
        <p id="filmBeschrijving">
            <%= film.getBeschrijving() %>
        </p>
        
    </div>
</div>


<%@ include file="templates/Footer.jsp" %>