<%@ include file="templates/Header.jsp" %>

    <div class="itemWrapper" id="loginFormat">
        <div id="loginForm" class="center">
            <form method="POST" action="LoginServlet">
                <label>- Email -</label>
                <input type="email" name="email" placeholder="E-mail address" required>
                <label>- Password -</label>
                <input type="password" name="pass" placeholder="Password" required>
                <input type="submit" class="button" value="Log in">
            </form>
            <p><a href="registerPage.jsp">No account yet?</a></p>
        </div>
        
        <p id="errorLogin">
            <% Object error = request.getAttribute("errorLogin"); %>
            <% if (error != null) { %>
                <%= error.toString() %>
            <%  } %>
            <br>
            <%  Object logFirst = request.getSession().getAttribute("logFirst"); %>
            <% if (logFirst != null) { %>
                <%= logFirst.toString() %>
            <%  } %>
        </p>
    </div>

<%@ include file="templates/Footer.jsp" %>
