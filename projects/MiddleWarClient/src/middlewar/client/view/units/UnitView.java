/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view.units;

import middlewar.client.view.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.Game;
import middlewar.common.*;
import middlewar.client.business.units.*;

import middlewar.client.exception.ClientException;
import middlewar.client.exception.DataException;

/**
 * Unit designer
 * @author higurashi
 */
public class UnitView extends View{

    private Unit unit;

    public UnitView(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {

        int vdec = 5;

        // shadow
        Image shadow = Game.getImage(UnitGraphicalPart.getShadowUrl());
        int h = shadow.getHeight(null);
        int w = shadow.getWidth(null);
        g.drawImage(shadow, position.getPxX()-(w/2)+(Constants.blockPxSize/2), position.getPxY()+Constants.blockPxSize-(Constants.blockPxSize/2)-vdec+3, io);

        // Graph. parts
        for (int o = 0; o <= unit.getMaxOrder(); o++) {
            for (UnitGraphicalPart gp : unit.getGraphics()) {
                if (unit.getOrientation() == Orientation.DOWN && gp.getDownOrder() == o) {
                    g.drawImage(gp.getDownImage(io), position.getPxX(), position.getPxY()-vdec, io);
                } else if (unit.getOrientation() == Orientation.LEFT && gp.getLeftOrder() == o) {
                    g.drawImage(gp.getLeftImage(io), position.getPxX(), position.getPxY()-vdec, io);
                } else if (unit.getOrientation() == Orientation.UP && gp.getUpOrder() == o) {
                    g.drawImage(gp.getUpImage(io), position.getPxX(), position.getPxY()-vdec, io);
                } else if (unit.getOrientation() == Orientation.RIGHT && gp.getRightOrder() == o) {
                    g.drawImage(gp.getRightImage(io), position.getPxX(), position.getPxY()-vdec, io);
                }
            }
        }
        
    }

}

