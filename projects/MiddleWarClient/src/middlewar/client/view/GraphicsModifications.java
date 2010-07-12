/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view;

import java.awt.*;
import java.awt.image.*;

/**
 * Graphics tranformations
 * @author higurashi
 */
public class GraphicsModifications {

    public static BufferedImage convert(BufferedImage image){
        GraphicsConfiguration configuration = GraphicsEnvironment
        .getLocalGraphicsEnvironment().getDefaultScreenDevice()
        .getDefaultConfiguration();

        BufferedImage img = configuration.createCompatibleImage(image.getWidth()
        ,image.getHeight(),Transparency.TRANSLUCENT);

        Graphics2D g2 = (Graphics2D)img.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();


        return img;
    }

}
