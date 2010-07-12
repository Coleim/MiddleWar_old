/*
 * Middle War Client
 * 
 */

package middlewar.client.view.world;

import middlewar.client.view.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Hashtable;
import middlewar.client.business.AgentWorld;
import middlewar.common.*;
import middlewar.client.exception.ClientException;

/**
 * Display world agent
 * @author higurashi
 */
public class AgentWorldView extends View{

    private AgentWorld world;

    public AgentWorldView(AgentWorld world) {
        this.world = world;
    }

    public void paint(Graphics g,ImageObserver io,Position position, int layer) throws ClientException{

        paint(g, io, position,layer,0);
        
        if(layer == 0){
            paint(g, io, position,layer,1);
            paint(g, io, position,layer,2);
        }

    }

    public void paint(Graphics g,ImageObserver io,Position position, int layer, int order) throws ClientException{
        Hashtable<BlockPosition,Image> list =  world.getBlocks(layer,order);
        //System.out.println(">>>"+list.size()+",layer="+layer+",o="+order);
        for (BlockPosition p : list.keySet()) {

            //if(isFocused(p)){

            //g.drawImage(list.get(p), p.getPxX() + position.getPxX(), p.getPxY() + position.getPxY(), io);
            //}
            //MwGraphicBlock mwgb = new MwGraphicBlock(list.get(p));
            //System.out.println("image@"+p.toString());
        }
    }

    public AgentWorld getWorld() {
        return world;
    }

    public void setWorld(AgentWorld world) {
        this.world = world;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        this.paint(g, io, position, 0);
        this.paint(g, io, position, 1);
    }

    public void paintBack(Graphics g,ImageObserver io,Position position) throws ClientException{
        this.paint(g, io, position, 0);
    }

    public void paintFront(Graphics g,ImageObserver io,Position position) throws ClientException{
        this.paint(g, io, position, 1);
    }

    private boolean isFocused(BlockPosition p) {
        return world.isPositionFocused(p);
    }

}

