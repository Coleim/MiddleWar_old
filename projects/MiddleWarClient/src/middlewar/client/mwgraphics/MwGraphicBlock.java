/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.client.mwgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.ImageObserver;
import middlewar.client.exception.ClientException;
import middlewar.common.Constants;
import middlewar.common.Position;

/**
 *
 * @author Jonathan
 */
public class MwGraphicBlock implements MwGraphicElement{

    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        Polygon p = new Polygon();
        p.addPoint(position.getPxX(), position.getPxY()+Constants.blockPxSize);
        p.addPoint(position.getPxX()+Constants.blockPxSize, position.getPxY());
        p.addPoint(position.getPxX()+2*Constants.blockPxSize, position.getPxY()+Constants.blockPxSize);
        p.addPoint(position.getPxX()+Constants.blockPxSize, position.getPxY()+2*Constants.blockPxSize);
        g.setColor(Color.DARK_GRAY);
        g.drawPolygon(p);
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(p);
    }
}
