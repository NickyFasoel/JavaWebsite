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
        </div>
        <p id="errorLogin"><% if (request.getSession().getAttribute("errorLogin") != null) { %>
                    <%= request.getSession().getAttribute("errorLogin") %>
            <%  } %>
        </p>
        <p><a href="">No account yet?</a></p>
    </div>

<%@ include file="templates/Footer.jsp" %>
