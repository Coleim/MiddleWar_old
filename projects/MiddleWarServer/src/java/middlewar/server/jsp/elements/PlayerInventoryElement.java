/*
 * Middle War - Server
 *
 */

package middlewar.server.jsp.elements;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.server.Server;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.jsp.JspElement;
import javax.servlet.http.HttpServletRequest;
import middlewar.common.BlockPosition;
import middlewar.common.BlockSurface;
import middlewar.server.worldmaker.business.AnimationType;
import middlewar.server.worldmaker.business.BlockType;
import middlewar.server.worldmaker.business.Map;
import middlewar.server.worldmaker.business.MapBuilder;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.html.MapVisual;

/**
 * Show the list of player unit
 * @author Higurashi
 */
public class PlayerInventoryElement extends JspElement {

    public PlayerInventoryElement(HttpServletRequest request,String playerId, String playerKey){
        super(request,playerId,playerKey);
    }
    
    @Override
    public void printJspHtml(Writer out) throws IOException, ServerException {
        try {

            Unit u = Server.unitManager.getUnit(Server.playerManager.getPlayerById(playerId).getSelectedUnitId());
            out.write(u.getId());
            out.write("<br/>");
            Map world = new Map(new BlockSurface(3, 3), "world-test");
            MapBuilder wb = new MapBuilder(world);
            wb.addPatternBlock(3, 3, BlockPosition.origin, BlockType.dev_nice, true);
            wb.buildWorld();
            MapVisual mv = new MapVisual(world);
            mv.printHtml(out);
            out.write("<br/>");
            out.write("<br/>");
            out.write("<br/>");
            out.write("<br/>");
            out.write("<br/>");
            out.write("<br/>");
            out.write("<br/>");

        } catch (WorldMakerException e) {
            out.write(e.getMessage());
        }
    }

}
