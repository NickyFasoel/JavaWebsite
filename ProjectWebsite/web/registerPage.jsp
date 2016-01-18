<%@ include file="templates/Header.jsp" %>

<div class="itemWrapper" id="loginFormat">
    <div id="loginForm" class="center">
        <form method="POST" action="RegisterServlet">
            <label>- Surname -</label>
            <input type="naam" name="naam" placeholder="Surname" required>
            <label>- First Name -</label>
            <input type="firstName" name="voornaam" placeholder="First name" required>
            <label>- Email -</label>
            <input type="email" name="email" placeholder="E-mail address" required>
            <label>- Password -</label>
            <input type="password" name="pass" placeholder="Password" required>
            <input type="submit" class="button" id="registerButton" value="Register">
        </form>
        <p id="errorLogin"><% if (request.getSession().getAttribute("alreadyExists") != null) { %>
                <%= request.getSession().getAttribute("alreadyExists") %>
            <%  } %>
        </p>
    </div>
</div>

<%@ include file="templates/Footer.jsp" %>