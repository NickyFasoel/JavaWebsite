<%@ include file="templates/Header.jsp" %>

<% // zodat de loginfirst boodschap reset anders blijft dit staan
    request.getSession().setAttribute("logFirst", null); %>

<div class="itemWrapper">
    
    <p>
        Test
    </p>
    
</div>

<%@ include file="templates/Footer.jsp" %>