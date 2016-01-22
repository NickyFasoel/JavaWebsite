<%@page import="Entities.TblFilm"%>
<%@page import="Entities.TblVertoning"%>
<%@page import="java.util.List"%>

<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper">
    <div id="infoPageWrapper" class="center">

        <%  /**
              *  deze lange codeblock vult de comboboxes en eventueel onderbreekt
              *  als de id niet klopt
              */
            Object tempObj = request.getAttribute("id");
            if (tempObj != null) {
                request.getSession().setAttribute("id", tempObj.toString());
            }
            long id = Long.parseLong(request.getSession().getAttribute("id").toString());
            TblFilm selectedFilm = null;
            List<TblFilm> lst = (List<TblFilm>) request.getSession().getAttribute("films");
            for (TblFilm film : lst) { 
                if (film.getId() == id) { 
                    selectedFilm = film; 
                    String tmp = selectedFilm.getImage(); 
                    String path= tmp.substring(0, 1).toLowerCase() + tmp.substring(1);
                    // de form in een foreach kan geen kwaad hier omdat de id unique is in database
        %>
                    <img class="itemImage" src="<%= path %>">
                    <h2 class="marginbot25 gold" id="underline"><%= selectedFilm.getNaam() %></h2>
                    <form method="POST" action="PayServlet">
                        <h3>Select a day:</h3>
                        <select name="speeldag" class="ddl">
        <%          String[] speelDagen = selectedFilm.getSpeeldagen().split(",");
                    for (String temp : speelDagen) { 
                        String dag = temp.trim(); 
        %>
                        <option value="<%= dag %>"><%= dag %></option>
        <%          }
                }
            }
                // id is niet bestaande in de film list
            if (selectedFilm == null) {
                response.sendRedirect("index.jsp");
                // anders voert hij de code vanonder nog uit en crashed
                return;
            }
        %>
            </select>
            <h3 class="margintop10">Select a time:</h3>
            <select name="speeluur" class="ddl">
        <%         
            String[] speelUren = selectedFilm.getSpeeluren().split(",");
                for (String temp : speelUren) { 
                    String uur = temp.trim(); 
        %>
                    <option value="<%= uur %>"><%= uur %></option>
        <%      } 
        %>
            </select>
            <h3 class="margintop10">How many tickets?</h3>
            <input type="number" min="1" max="9" name="tickets" placeholder="Amount" id="nr" class="textCenter" required>
            <input type="hidden" name="film" value="<%= String.valueOf(selectedFilm.getId()) %>"></input>
            <div class="hr"></div>
            <button type="submit" class="button marginbot15 margintop10">Buy</button>
        </form>
    </div>
    <p id="error">
        <%  Object error = request.getAttribute("voorstellingError");
            if (error != null) { %>
                <%= error.toString() %> 
        <%  }
        %>   
    </p>        
</div>

<%@ include file="templates/Footer.jsp" %>