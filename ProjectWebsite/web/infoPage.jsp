<%@page import="java.util.List"%>
<%@page import="Entities.TblVertoning"%>
<%@page import="Entities.TblFilm"%>

<%@ include file="templates/Header.jsp" %>


<div class="itemWrapper">
    <div id="infoPageWrapper" class="center">
        
        <% 
            TblFilm film = (TblFilm) request.getSession().getAttribute("selectedFilm"); 
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
        
        <a href="" class="button" id="buyTicketsBtn">Buy Tickets</a>
        
        <h2 style="float: left; padding: 8px; clear: both;">Description:</h2>
        <p id="filmBeschrijving">
            <%= film.getBeschrijving() %>
        </p>
        
    </div>
</div>


<%@ include file="templates/Footer.jsp" %>