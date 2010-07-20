<%@page import="middlewar.server.jsp.elements.PlayerInventoryElement"%>
<%@page import="middlewar.server.jsp.elements.PlayerUnitsListElement"%>
<%@page import="middlewar.server.jsp.JspElement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="middlewar.server.ServerSecurity" %>
<%@page import="middlewar.server.Server" %>
<%@page import="middlewar.server.business.unit.*" %>
<%@page import="middlewar.common.MiddlewarConfiguration"%>

<%

String pkey = "";
String playerId = (String)session.getAttribute("player");

if(session.getAttribute("player") != null){
    pkey = ServerSecurity.getPlayerKey(playerId);
}

// load player infoss
Server.unitManager.LoadPlayerUnits(playerId);


// jsp elements
JspElement eUnitList = new PlayerUnitsListElement(request, playerId, pkey);
eUnitList.setJsCallOnClick("eUnitListOnClick();");



%>

<div class="art-contentLayout">
    <div class="art-sidebar1">
        <div class="art-Block">
            <div class="art-Block-tl"></div>
            <div class="art-Block-tr"></div>
            <div class="art-Block-bl"></div>
            <div class="art-Block-br"></div>
            <div class="art-Block-tc"></div>
            <div class="art-Block-bc"></div>
            <div class="art-Block-cl"></div>
            <div class="art-Block-cr"></div>
            <div class="art-Block-cc"></div>
            <div class="art-Block-body">
                <div class="art-BlockHeader">
                    <div class="l"></div>
                    <div class="r"></div>
                    <div class="art-header-tag-icon">
                        <div class="t">Amis</div>
                    </div>
                </div>
                <div class="art-BlockContent">
                    <div class="art-BlockContent-body">
                        <div>
                            

                        <br/><br/><br/><br/><br/><br/>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   <div class="art-content">
        <div class="art-Post">
            <div class="art-Post-body">
                <div class="art-Post-inner">
                    <div class="art-PostContent">
                    <applet
                        code = "middlewar.client.MainApplet"
                        codebase="."
                        archive= "<%=MiddlewarConfiguration.getClientDistPath()%>,
                                  <%=MiddlewarConfiguration.getCommonDistPath()%>,
                                  <%=MiddlewarConfiguration.getXMWPDistPath()%>"
                        width = "416"
                        height="496">
                        <param name="key" value="<%out.print(pkey);%>"/>
                    </applet>
                    </div>
                    <div class="cleared"></div>
                </div>
            </div>
        </div>
        <div class="art-Post">
            <div class="art-Post-body">
                <div class="art-Post-inner"></div>
            </div>
        </div>
    </div>
    <div class="art-sidebar2">

        <!-- units -->
        <div class="art-Block">
            <div class="art-Block-tl"></div>
            <div class="art-Block-tr"></div>
            <div class="art-Block-bl"></div>
            <div class="art-Block-br"></div>
            <div class="art-Block-tc"></div>
            <div class="art-Block-bc"></div>
            <div class="art-Block-cl"></div>
            <div class="art-Block-cr"></div>
            <div class="art-Block-cc"></div>

            <div class="art-Block-body">
                <div class="art-BlockHeader">
                    <div class="l"></div>
                    <div class="r"></div>
                    <div class="art-header-tag-icon">
                        <div class="t">Units</div>
                    </div>
                </div>
                <div class="art-BlockContent">
                    <div class="art-BlockContent-body">
                        <div>
                            <script type="text/javascript">
                                function eUnitListOnClick(){
                                    <%
                                        out.print("loadContent('../MiddleWarHTTPServer?key="+pkey+"&action=gethtml&jspelement=inventory','div_player_inventory');\n");
                                    %>
                                }
                            </script>
                            <%

                            eUnitList.printHtml(out);
                            
                            %>
                            
                        </div>
                    </div>
                </div>
            </div>
         </div>


         <!-- inventaire -->
         <div class="art-Block">
            <div class="art-Block-tl"></div>
            <div class="art-Block-tr"></div>
            <div class="art-Block-bl"></div>
            <div class="art-Block-br"></div>
            <div class="art-Block-tc"></div>
            <div class="art-Block-bc"></div>
            <div class="art-Block-cl"></div>
            <div class="art-Block-cr"></div>
            <div class="art-Block-cc"></div>
            <div class="art-Block-body">
                <div class="art-BlockHeader">
                    <div class="l"></div>
                    <div class="r"></div>
                    <div class="art-header-tag-icon">
                        <div class="t">Inventaire</div>
                    </div>
                </div>
                <div class="art-BlockContent">
                    <div class="art-BlockContent-body">
                        <div id="div_player_inventory">
                            <%


                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>