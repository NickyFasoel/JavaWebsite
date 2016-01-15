        <div class="bottomLine">
            
        </div>
        <footer>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@page import="java.util.Date"%>
            <%@page import="java.util.Calendar"%>
            <% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
            <c:out value="Nicky Fasoel - Java Kinepolis Project - ${currentYear}" />
        </footer>
    </body>
</html>