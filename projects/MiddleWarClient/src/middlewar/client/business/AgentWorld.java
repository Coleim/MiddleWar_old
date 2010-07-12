/*
 * Middle War - Client
 *
 */

package middlewar.client.business;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import middlewar.client.business.world.*;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;

/**
 * World game agent
 * @author higurashi
 */
public class AgentWorld implements Agent{

    private Hashtable<String,World> worlds;

    private String focusWorld;
    private BlockPosition focusPosition;


    public static final int X = 13;
    public static final int Y = 13;


    public AgentWorld() {
        worlds = new Hashtable<String, World>();
        focusPosition = new BlockPosition(0, 0);
        focusWorld = "basic";
    }

    public BlockPosition getFocusPosition() {
        return focusPosition;
    }

    public void setFocusPosition(BlockPosition focusPosition) {
        this.focusPosition = focusPosition;
    }

    public String getFocusWorld() {
        return focusWorld;
    }

    public void setFocusWorld(String focusWorld) {
        this.focusWorld = focusWorld;
    }

    

    public boolean isPositionFocused(BlockPosition p){
        boolean focus = false;
        if(focusPosition.getBlockX()-X < p.getBlockX() &&
                focusPosition.getBlockX()+X > p.getBlockX() &&
                focusPosition.getBlockY()-Y < p.getBlockY() &&
                focusPosition.getBlockY()+Y > p.getBlockY() ) focus = true;
        return focus;
    }


    public boolean isBlockPassing(int x, int y){
        World world = worlds.get(focusWorld);
        return !( !world.isPassing(x, y, Orientation.UP) &&
                !world.isPassing(x, y, Orientation.DOWN) &&
                !world.isPassing(x, y, Orientation.LEFT) &&
                !world.isPassing(x, y, Orientation.RIGHT));

    }

    public boolean isBlockInWorld(int x,int y) throws ClientException{
        return x >= 0 && y >=0  && x<AgentWorld.X && y<AgentWorld.Y;
    }

    public void setBlock(int x, int y, int layer, int order, String worldName, String image) throws ClientException {
        try {
            World world = worlds.get(worldName);
            world.addImage(Game.getImage(new URL(Game.DATA_URL_BLOCKS + image)),
                                x,
                                y,
                                layer,
                                order
                               );
            
        } catch (MalformedURLException e) {
            throw new ClientException(e);
        }
    }



    /**
     * @see GameAgent
     */
    public void stop(){ }

    /**
     * @see GameAgent
     */
    public void start() { }

    public Hashtable<BlockPosition, Image> getBlocks(int layer, int order) throws ClientException {
        World world = worlds.get(focusWorld);
        return world.getBlocks(layer, order);
    }

}
