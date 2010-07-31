/*
 * Middle War - Server
 *
 */

package middlewar.server;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import middlewar.server.business.player.Player;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.jsp.JspElement;
import middlewar.server.jsp.elements.PlayerInventoryElement;
import middlewar.xmwp.*;
import middlewar.xmwp.elements.inform.ErrorInformElement;

/**
 * HTTP/XMWP Server servlet.
 * @author higurashi
 */
public class MiddleWarHTTPServer extends HttpServlet {

    /**
     *
     * Receive HTTP Requests with following parameters
     * <ul>
     *  <li><b>key</b> : the user auth key on server</li>
     *  <li><b>action</b> : the action to execute</li>
     * </ul>
     * there may be optionals parameters. The call of the servlet will generate
     * XMWP message that will be sent to the client.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Server.logs.logInfo("HTTPServer called by "+request.getRemoteAddr());

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");

        try{

            // get the player
            String key = request.getParameter("key");
            String playerId = ServerSecurity.getPlayerId(key);
            if(key == null || playerId==null) throw new ServerException("invalid key");
            Player p = Server.playerManager.getPlayerById(playerId);

            try {

                String action = request.getParameter("action");

                // Focus on a specified unit
                if(action.equals("focusUnit")){

                    String unitId = request.getParameter("unitId");

                    if(unitId == null) throw new ServerException("need parameter : unitId");

                    Unit u = Server.unitManager.getUnit(unitId);

                    if(u.getPlayerId().equals(playerId)){

                        p.addXMWPUpdate(u.getXMWPElement(true));
                        out.print("ok");

                    }else throw new ServerException("you can not focus on others players units");

                }
                else if (action.equals("gethtml")) {

                    String jspelement = request.getParameter("jspelement");

                    if(jspelement.equals("inventory")){

                        JspElement eUnitInv = new PlayerInventoryElement(request, playerId, key);
                        eUnitInv.printHtml(out);

                    }

                }
                else throw new ServerException("no action specified");
                
            } catch (ServerException e) {
                Server.logs.logError(e,this.getClass().getSimpleName());
                p.addXMWPUpdate(new ErrorInformElement(e.getMessage()));
            }

        } catch(XMWPException e){
            Server.logs.logError(e,this.getClass().getSimpleName());
        } catch (ServerException e) {
            Server.logs.logError(e,this.getClass().getSimpleName());
        } catch (Exception e) {
            Server.logs.logError(e);
        } finally {
            out.print("</html>");
            out.close();
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Middle War HTTP/XMWP server";
    }

}
