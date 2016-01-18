<!DOCTYPE html>
<html>
    <head>
        <title>Kinepolis - Project</title>
        <meta charset="UTF-8"/>
        <meta name="description" content="Header Template"/>
        <meta name="keywords" content="HTML,CSS, JavaScript"/>
        <meta name="author" content="Nicky Fasoel"/>
        <link href="css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="images/favicon.png" rel="icon" type="image/x-icon"/>
    </head>
    <body>
        <header>
            <img class="logo" src="images/logoKlein.png">
            <h1>Kinepolis</h1>
        </header>
        <nav>
            <ul>
                <li class="navItems"><a href="index.jsp">Home</a></li>
                <li class="navItems"><a href="trailers.jsp">Trailers</a></li>
                <%  String naam, pag;
                    if (request.getSession().getAttribute("user") != null) {
                        naam = request.getSession().getAttribute("user").toString();
                        pag = "logOutServlet";
                    } else { 
                        naam = "Log in";
                        pag = "loginPage.jsp";
                    } %>
                <li class="navItems"><a href=<%= pag %>><%= naam %></a></li>
            </ul>
        </nav>
        <section>
            <div class="center">