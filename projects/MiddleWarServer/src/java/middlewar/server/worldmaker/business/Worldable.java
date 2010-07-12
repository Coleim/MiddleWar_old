/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.Worldable.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.common.*;
import java.util.Vector;

/**
 * World modificator element ( see patterns, subclasses )
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class Worldable {

    protected Map map;              // the map to modify
    protected Position position;    // the base position of the modification

    /**
     * Change the map to modify
     * @param map the map
     */
    public void setMap(Map map){
        this.map = map;
    }

    /**
     * Constructor
     * @param position the base position of the modification
     */
    public Worldable(Position position) {
        this.position=position;
    }

    /**
     * Constructor
     * @param map the map to modify
     * @param position the base position of the modification
     */
    public Worldable(Position position,Map map) {
        this.position=position;
        this.map = map;
    }

    /**
     * Return the base position of the modificator
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Modify the position of the modificator
     * @param position the new position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Apply the modifications
     * @throws failure.wm.business.WorldMakerException
     */
    public abstract void build() throws WorldMakerException;

    /**
     * Add a block to the map
     * @param x position (x) , relative
     * @param y position (y) , relative
     * @param layer the layer to use
     * @param type the type of the block
     * @param passing true if it's possible to pass over the block
     * @throws failure.wm.business.WorldMakerException
     */
    protected void setBlock(int x, int y, int layer, BlockType type,boolean passing) throws WorldMakerException {
        if(this.map == null)
            throw new WorldMakerException("no blocks , no map set");
        
        if(type != null){

            int order = 0;

            MapPosition p = new MapPosition(x+this.position.getBlockX(), y+this.position.getBlockY(),layer,order,map.getName());

            if(x<map.getSurface().getBlockX() && y<map.getSurface().getBlockY()
               && x>=0 && y>=0 && layer >= 0 && order >= 0
               ){
                
                    while(this.map.getBlocks().containsKey(p)){
                        order++;
                        p.setOrder(order);

                    }
                    this.map.addBlock(new Block(p,type,passing));

            }
        }
        
    }

    /**
     * Add a animated block to the map
     * @param x position (x) , relative
     * @param y position (y) , relative
     * @param layer the layer to use
     * @param blocks the types of the blocks ( frame of animation )
     * @param delays the inter-frame delays
     * @param passing true if it's possible to pass over the block
     * @throws failure.wm.business.WorldMakerException
     */
    protected void setAnimatedBlock(int x, int y, int layer, BlockType[] blocks,int[] delays,boolean passing) throws WorldMakerException {
        if(this.map == null)
            throw new WorldMakerException("no blocks , no map set");

        int order = 0;

        MapPosition p = new MapPosition(x+this.position.getBlockX(), y+this.position.getBlockY(),layer,order,map.getName());

        if(x<map.getSurface().getBlockX() && y<map.getSurface().getBlockY()
           && x>=0 && y>=0 && layer >= 0 && order >= 0
           ){

                while(this.map.getBlocks().containsKey(p)){
                    order++;
                    p.setOrder(order);

                }
                this.map.addBlock(new BlockAnimated(p,blocks,delays,passing));

        }
    }

    protected void setTeleportBlock(int x, int y,int layer, WorldName destinationMetaWorld, BlockPosition destinationPosition) throws WorldMakerException {
        if(this.map == null)
            throw new WorldMakerException("no blocks , no map set");

        int order = 0;

        MapPosition p = new MapPosition(x+this.position.getBlockX(), y+this.position.getBlockY(),layer,order,map.getName());

        if(x<map.getSurface().getBlockX() && y<map.getSurface().getBlockY()
           && x>=0 && y>=0 && layer >= 0 && order >= 0
           ){

                while(this.map.getBlocks().containsKey(p)){
                    order++;
                    p.setOrder(order);

                }
                this.map.addBlock(new BlockTeleport(p,destinationMetaWorld,destinationPosition));

        }
    }

    protected void setCollisionBlock(int x, int y, int layer, Orientation orientation) throws WorldMakerException {
        if(this.map == null)
            throw new WorldMakerException("no blocks , no map set");

        int order = 0;

        MapPosition p = new MapPosition(x+this.position.getBlockX(), y+this.position.getBlockY(),layer,order,map.getName());

        if(x<map.getSurface().getBlockX() && y<map.getSurface().getBlockY()
           && x>=0 && y>=0 && layer >= 0 && order >= 0
           ){

                while(this.map.getBlocks().containsKey(p)){
                    order++;
                    p.setOrder(order);

                }
                this.map.addBlock(new BlockCollision(p,orientation));

        }
    }

}
