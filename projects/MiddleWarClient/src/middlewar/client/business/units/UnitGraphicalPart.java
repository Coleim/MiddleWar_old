/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.business.units;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.Game;
import middlewar.common.*;
import middlewar.client.exception.*;

/**
 * graphical part of an unit
 * @author higurashi
 */
public class UnitGraphicalPart {

    private String name;
    private int[] orders = new int[4];
    private BufferedImage[] images = new BufferedImage[4];


    public static URL shadowUrl = null;

    public UnitGraphicalPart(String name) {

        this.name = name;
        setDownOrder(0);
        setUpOrder(0);
        setLeftOrder(0);
        setRightOrder(0);
        images[0] = null;
        images[1] = null;
        images[2] = null;
        images[3] = null;
    }

    public static URL getShadowUrl() throws ClientException{
        if(shadowUrl==null){
            try {
                shadowUrl = new URL(Game.DATA_URL_UNITS + "shadow.png");
            } catch (MalformedURLException e) {
                throw new ClientException(e);
            }
        }
        return shadowUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private BufferedImage getImage(String name,ImageObserver io) throws DataException, ClientException{
        BufferedImage bi = null;
        URL url = null;
        try {
            url = new URL(Game.DATA_URL_UNITS + this.name + "/" + name);
            Image img=Game.getImage(url);
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(img, 0, 0, null);
        } catch (MalformedURLException e) {
            throw new DataException("can not get image : "+ name,url);
        } catch (IllegalArgumentException e){
            throw new DataException("can not get image : "+ name,url);
        }
        return bi;
    }

    public Image getDownImage(ImageObserver io) throws DataException, ClientException{
        if(images[0] == null){
            images[0] = getImage("D_0.png",io);
        }
        return images[0];
    }

    public Image getUpImage(ImageObserver io) throws ClientException{
        if(images[1] == null){
            images[1] = getImage("U_0.png",io);
        }
        return images[1];
    }

    public Image getLeftImage(ImageObserver io) throws ClientException{
        if(images[2] == null){
            images[2] = getImage("L_0.png",io);
        }
        return images[2];
    }

    public Image getRightImage(ImageObserver io) throws ClientException{
        if(images[3] == null){
            images[3] = getImage("R_0.png",io);
        }
        return images[3];
    }

    public int getDownOrder() {
        return orders[0];
    }

    public int getUpOrder() {
        return orders[1];
    }

    public int getLeftOrder() {
        return orders[2];
    }

    public int getRightOrder() {
        return orders[3];
    }

    public void setDownOrder(int order) {
        orders[0] = order;
    }

    public void setUpOrder(int order) {
        orders[1] = order;
    }

    public void setLeftOrder(int order) {
        orders[2] = order;
    }

    public void setRightOrder(int order) {
        orders[3] = order;
    }


}
