<%@ include file="templates/Header.jsp" %>


<div class="center">
    <div class="itemWrapper" id="loginFormat">
        <div id="loginForm" class="center">
            <form method="POST" action="LoginServlet">
                <label>- Email -</label>
                <input type="e-mail" name="email" placeholder="E-mail address">
                <label>- Password -</label>
                <input type="password" name="pass" placeholder="Password">
                <input type="submit" class="button" value="Log in">
            </form>
        </div>
    </div>
   
    
</div>


<%@ include file="templates/Footer.jsp" %>
