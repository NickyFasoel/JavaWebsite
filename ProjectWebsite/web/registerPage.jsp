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
    </div>
        <p id="error">
            <%  // als de email al bestaat => errorMessage hier
                Object objError = request.getAttribute("alreadyExists");
                if (objError != null) { %>
                <%= objError.toString() %>
            <%  } %>
        </p>
</div>

<%@ include file="templates/Footer.jsp" %>