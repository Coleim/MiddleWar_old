<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="middlewar.server.ServerSecurity" %>


<%

String login = request.getParameter("login");
String password = request.getParameter("password");

if(login != null && password != null){

    if(ServerSecurity.verifyPassword(login, password)){
        String playerId = login;
        // Log in
        ServerSecurity.getNewPlayerKey(playerId);
        session.setAttribute("player", new String(playerId));
    }

}



%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Middle War</title>
    <script type="text/javascript" src="script_css.js"></script>
    <script type="text/javascript" src="script_ajax.js"></script>
    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="../WorldMaker/wm-common.css" type="text/css" media="screen" />
</head>
<body>
<div id="art-page-background-glare">
    </div>
    <div id="art-main">
        <div class="art-Sheet">

            <!-- css design -->
            <div class="art-Sheet-tl"></div><div class="art-Sheet-tr"></div><div class="art-Sheet-bl"></div><div class="art-Sheet-br"></div><div class="art-Sheet-tc"></div><div class="art-Sheet-bc"></div><div class="art-Sheet-cl"></div><div class="art-Sheet-cr"></div><div class="art-Sheet-cc"></div>

            <div class="art-Sheet-body">

                <!-- header -->
                <div class="art-Header">
                    <div class="art-Header-jpeg"></div>
                    <div class="art-Logo"></div>
                </div>

                <%

                String p = request.getParameter("p");

                %>

                <!-- menu -->
                <div class="art-nav">
                	<div class="l"></div><div class="r"></div>
                	<ul class="art-menu">
                            <li><a href="./index.jsp" <% if(p==null || p.equals("main")) out.print("class='active'"); %>><span class="l"></span><span class="r"></span><span class="t">Jeu</span></a></li>
                		<li><a href="./index.jsp?p=register" <% if(p!=null && p.equals("register")) out.print("class='active'"); %>><span class="l"></span><span class="r"></span><span class="t">Inscription</span></a></li>
                		<li><a href="./index.jsp?p=infos" <% if(p!=null && p.equals("infos")) out.print("class='active'"); %>><span class="l"></span><span class="r"></span><span class="t">Informations</span></a></li>
                        </ul>
                </div>

                <!-- page -->

               <%

               if(p != null){

                   if(p.equals("register")){
                        %><%@include file='./register.jsp'%><%
                   }
                   else if(p.equals("main")){
                        %><%@include file='./main.jsp'%><%
                   }
                   else if(p.equals("infos")){
                        %><%@include file='./infos.jsp'%><%
                   }

               }
               else{

                   if(session.getAttribute("player") != null){
                       %><%@include file='./main.jsp'%><%
                       
                   }
                   else{
                       %><%@include file='./log.jsp'%><%
                   }

               }

               %>

                <div class="cleared"></div><div class="art-Footer">
                    <div class="art-Footer-inner">
                        <div class="art-Footer-text">
                            <p><a href="#">Contact Us</a> | <a href="#">Terms of Use</a> | <a href="#">Trademarks</a>
                                | <a href="#">Privacy Statement</a><br />
                                Copyright &copy; 2009 . All Rights Reserved.</p>
                        </div>
                    </div>
                    <div class="art-Footer-background"></div>
                </div>
            </div>
        </div>
        <div class="cleared"></div>
        <p class="art-page-footer">XHTML CSS valid</p>
    </div>
</body>
</html>

