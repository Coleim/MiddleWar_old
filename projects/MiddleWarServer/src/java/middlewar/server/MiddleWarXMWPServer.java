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
import middlewar.server.exception.ServerException;
import middlewar.server.xmwp.XMWPServerLogic;
import middlewar.xmwp.*;
import middlewar.xmwp.server.*;
import middlewar.xmwp.logic.XMWPLogic;
import middlewar.xmwp.elements.inform.ErrorInformElement;

/**
 * XMWP Server servlet.
 * @author higurashi
 */
public class MiddleWarXMWPServer extends HttpServlet {
   
    /** 
     *
     * Receive XMWP messages , and return XMWP messages.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/xml;charset=UTF-8");

        try {
           
            Message recv = Message.parseMessageFromStream(request.getInputStream());

            // get player ID from key
            String playerId = ServerSecurity.getPlayerId(recv.getKey());
            if(playerId == null) throw new ServerException("You are not logged in (key="+recv.getKey()+")");

            Player p = Server.playerManager.getPlayerById(playerId);

            if(p == null) throw new ServerException("Unknown player (id="+playerId+")");

            XMWPLogic logic = new XMWPServerLogic(p.getId());

            Message resp = new ServerMessage();
            recv.processLogicOnMessage(logic, resp);

            resp.printMessageToStream(response.getOutputStream());

        } catch (XMWPException e) {
            sendError(e,response);
        } catch (Exception e) {
            sendError(e,response);
        }

    } 

    protected void sendError(Exception e,HttpServletResponse response) throws IOException{
         try {
                Message resp = new ServerMessage();
                resp.addInform(new ErrorInformElement(e.getClass().getName()+" > "+e.getMessage()));
                resp.printMessageToStream(response.getOutputStream());
            } catch (XMWPException xmwpe) {
                // todo log
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
        return "Middle War XMWP server";
    }

}
