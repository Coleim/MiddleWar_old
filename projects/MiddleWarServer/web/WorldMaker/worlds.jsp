<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WM doc - world</title>
    </head>

    <%@page import="middlewar.server.business.world.*" %>
    <%@page import="middlewar.server.worldmaker.business.*" %>
    <%@page import="middlewar.server.worldmaker.business.animations.*" %>
    <%@page import="middlewar.server.worldmaker.html.*" %>
    <%@page import="middlewar.common.*" %>

    <link href="./wm-style.css" rel="stylesheet" type="text/css" />
    <body>
    <a href="./index.jsp"><img src="./logo.png" class='logo' ></a>
    <br><b>World</b> (<a href="./index.jsp">index</a>)
    <br><br>
    <%
        String name = request.getParameter("name");

        WorldBuilder wb = new WorldBuilder(WorldName.valueOf(name));

        World w = wb.generate();
        w.save();
        for(String mn : w.getMapsNames()){
            Map map = World.loadMap(mn);
            MapVisual mv = new MapVisual(map);
            mv.printHtml(out);
        }

    %>
    </body>
</html>
