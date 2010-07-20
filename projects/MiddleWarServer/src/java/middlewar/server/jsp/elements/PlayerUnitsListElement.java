/*
 * Middle War - Server
 *
 */

package middlewar.server.jsp.elements;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import middlewar.server.Server;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.jsp.JspElement;
import javax.servlet.http.HttpServletRequest;

/**
 * Show the list of player unit
 * @author Higurashi
 */
public class PlayerUnitsListElement extends JspElement {

    public PlayerUnitsListElement(HttpServletRequest request,String playerId, String playerKey){
        super(request,playerId,playerKey);
    }

    @Override
    public void printJspHtml(Writer out) throws IOException, ServerException {
        ArrayList<Unit> units = Server.unitManager.getUnits(playerId);
        for(Unit u : units){
            String html;

            html = "<a style=\"cursor: pointer;\""+
                   "onclick=\"loadContent('../MiddleWarHTTPServer?key="+playerKey+"&action=focusUnit&unitId="+u.getId()+"',null); "+jsCallOnClick+" \""+
                   " >"+u.getId()+"</a>";

            out.write(html);
            out.write("<br/>");
        }
    }

}
