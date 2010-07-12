/*
 * Middle War - Client
 * 
 */

package middlewar.client.view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import middlewar.common.*;
import middlewar.client.exception.*;

/**
 * Basic graphic designer
 * @author higurashi
 */
public abstract class View{

    public abstract void paint(Graphics g,ImageObserver io,Position position) throws ClientException;

}

