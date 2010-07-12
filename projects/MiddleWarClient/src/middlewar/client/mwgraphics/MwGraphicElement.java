/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.client.mwgraphics;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import middlewar.client.exception.ClientException;
import middlewar.common.Position;

/**
 *
 * @author Jonathan
 */
public interface MwGraphicElement {

        public void paint(Graphics g,ImageObserver io, Position position) throws ClientException;

}
