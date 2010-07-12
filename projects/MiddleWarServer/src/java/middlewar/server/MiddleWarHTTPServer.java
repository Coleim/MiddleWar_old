/*
 * Middle War - Server
 *
 */

package middlewar.server;

import middlewar.xmwp.elements.inform.ByeInformElement;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import middlewar.server.business.player.Player;
import middlewar.server.business.player.PlayerManager;
import middlewar.server.exception.ServerException;

import middlewar.server.xmwp.XMWPServerLogic;
import middlewar.xmwp.*;
import middlewar.xmwp.server.*;
import middlewar.xmwp.elements.*;
import middlewar.xmwp.logic.XMWPLogic;

/**
 * Server servlet.
 * @author higurashi
 */
public class MiddleWarHTTPServer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String key = request.getParameter("key");
            String playerId = ServerSecurity.getPlayerId(key);
            if(key == null || playerId==null) throw new ServerException("invalid key");

            Player p = Server.playerManager.getPlayer(playerId);
            p.addXMWPUpdate(new ByeInformElement());

             out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");


        } catch (Exception e) {
            // todo
            e.printStackTrace();
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

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Middle War XMWP server";
    }

}
