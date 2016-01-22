<%@page import="java.util.List"%>
<%@page import="Entities.TblVertoning"%>
<%@page import="Entities.TblFilm"%>

<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper">
    <div id="infoPageWrapper" class="center">
        
        <%  // attr ophalen indien geen attr => opgevangen door catch in vorige page
            TblFilm film = (TblFilm) request.getAttribute("selectedFilm"); 
            String temp = film.getImage(); 
            // path weer aanpassen om te vinden refactor hielp niet (naam veranderen)
            String path = temp.substring(0, 1).toLowerCase() + temp.substring(1);
        %>

        <img id="selectedFilm" src="<%= path %>">
        
        <h2>Movie Days:</h2><br>
        <p>
            <%= film.getSpeeldagen() %>
        </p>
        
        <h2>Hours:</h2><br>
        <p>
            <%= film.getSpeeluren() %>       
        </p>
        
        <%  String pagina;
            if (request.getSession().getAttribute("user") != null) {
                pagina = "BuyTicketsServlet?Id=" + String.valueOf(film.getId()); 
            } else {
                pagina = "BuyTicketsServlet";
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