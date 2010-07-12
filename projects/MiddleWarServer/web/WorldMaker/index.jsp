<%-- 
    Document   : index
    Created on : 24 mai 2009, 14:57:44
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./wm-style.css" rel="stylesheet" type="text/css" />
        <title>WM doc</title>
    </head>

    <%@page import="middlewar.server.worldmaker.business.*" %>
    <%@page import="middlewar.server.worldmaker.business.animations.*" %>
    <%@page import="middlewar.server.worldmaker.html.*" %>
    <%@page import="middlewar.common.*" %>

    <body>
    <a href="./index.jsp"><img src="./logo.png" class='logo' ></a>
    <br><b>version 1.0 - Doc</b> (<a href="./lib.jsp">index</a>)
    <br><br>
        <ul class="menu">
        <li>
            <a href="./lib.jsp">Library</a><br>
            <ul>
            <li><a href="./lib.jsp#surfaces">Surfaces</a></li>
            <li><a href="./lib.jsp#elements">Elements</a></li>
            <li><a href="./lib.jsp#animations">Animations</a></li>
            <li><a href="./lib.jsp#blocks">Blocks</a></li>
            </ul>
            </li><br>
        <li>
            Worlds<br>
            <ul>
                <%

                for(WorldName name : WorldName.values()){
                    out.print("<li>");
                    out.print("<a href='./worlds.jsp?name="+name.name()+"'>"+name.name()+"</a>");
                    out.print("</li>");
                }
                
                %>
            </ul>
            </li><br>
        <li>Tutos
        <ul>
            <li><a href="./tutorials/tuto_1.html">tuto 1</a></li>
            <li><a href="./tutorials/tuto_2.html">tuto 2</a></li>
            <li><a href="./tutorials/tuto_3.html">tuto 3</a></li>
            <li><a href="./tutorials/tuto_4.html">tuto 4</a></li>
            <li><a href="./tutorials/tuto_5.html">tuto 5</a></li>
            </ul>
        </li><br>
            <!--
        <li>Fonctions
        <ul>
            <li><a href="./wbf_addPatternBlock.jsp"><i>WorldBuilder</i>.addPatternBlock</a></li>
            <li><a href="./wbf_addPatternSquare.jsp"><i>WorldBuilder</i>.addPatternSquare</a></li>
            <li><a href="./wbf_addPatternCustom.jsp"><i>WorldBuilder</i>.addPatternCustom</a></li>
            <li><a href="./wbf_addElementLayer0.jsp"><i>WorldBuilder</i>.addElementLayer0</a></li>
            <li><a href="./wbf_addElementLayer1.jsp"><i>WorldBuilder</i>.addElementLayer1</a></li>
            <li><a href="./wbf_addAnimationLayer0.jsp"><i>WorldBuilder</i>.addAnimationLayer0</a></li>
            </ul>
        </li>
         -->
        </ul>
       
    </body>
</html>
