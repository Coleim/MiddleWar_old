<%@page import="middlewar.server.ServerSecurity" %>
<%@page import="middlewar.common.MiddlewarConfiguration"%>

<%

String pkey = "";

if(session.getAttribute("player") != null){
pkey = ServerSecurity.getPlayerKey((String)session.getAttribute("player"));
}

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
                                        <div class="t">Connexion</div>
                                    </div>
                                </div><div class="art-BlockContent">
              
                                </div>
                            </div>
                        </div>
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
                                </div><div class="art-BlockContent">
                                    <div class="art-BlockContent-body">


                                        <div>
                                            <a onclick="loadContent('http://localhost:8080/MiddleWarServer/MiddleWarHTTPServer?key=<% out.print(pkey);%>&action=movetounit&unitId=test',null)">Test_1</a>

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
                                    <param name="key" value="
                                           
                                    <%

                                    
                                    out.print(pkey);
                                    

                                    %>
                                    "/>
        </applet>

                            </div>
                            <div class="cleared"></div>
                        </div>

                            </div>
                        </div>
                        <div class="art-Post">
                            <div class="art-Post-body">
                        <div class="art-Post-inner">
                        </div>

                            </div>
                        </div>
                    </div>
                    <div class="art-sidebar2">
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
                                        <div class="t">[...]</div>
                                    </div>
                                </div><div class="art-BlockContent">
                                    <div class="art-BlockContent-body">
                                        <div>
                                                          <p>...</p>

                                                          <p>...</p>
                                                          </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>