/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.Map.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.common.*;
import java.io.Serializable;
import java.util.*;

/**
 * Set of blocks
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class Map implements Serializable{

    protected Hashtable<MapPosition,Block> blocks;              // blocks
    protected BlockSurface surface;                             // surface of the map
    protected String name;                                      // name of the map
    protected Calendar creation;                                // date of creation

    /**
     * Constructor
     * @param surface the size of the map
     * @param name the name of the map
     * @throws failure.wm.business.WorldMakerException
     */
    public Map(BlockSurface surface,String name) throws WorldMakerException {
        this.creation = Calendar.getInstance();
        this.surface = surface;
        this.blocks = new Hashtable<MapPosition, Block>(surface.getBlockX()*surface.getBlockY());
        this.name = name;
    }

    /**
     * Return the date of the creation
     * @return the date of creation
     */
    public Calendar getCreation() {
        return creation;
    }

    /**
     * Return the blocks
     * @return the blocks
     */
    public Hashtable<MapPosition,Block> getBlocks() {
        return this.blocks;
    }

    /**
     * Return the block for position
     * @param position the blocks position
     * @return the block
     */
    public Block getBlock(MapPosition position) {
        return this.blocks.get(position);
    }

    /**
     * Merge map blocks in current map
     * @param Map the map to merge
     */
    public void addMapBlocks(Map map) {
        Enumeration<Block> list = map.getBlocks().elements();
        while(list.hasMoreElements()){
            this.addBlock(list.nextElement());
        }
    }

    /**
     * Add a block to the map
     * @param b the block to add
     */
    public void addBlock(Block b) {
        this.blocks.put(b.getPosition(),b);
    }

    /**
     * Return the surface of the map
     * @return the surface
     */
    public BlockSurface getSurface() {
        return surface;
    }

    /**
     * Modify the surface of the map
     * @param surface the new surface
     */
    public void setSurface(int x,int y) {
        this.surface.setBlockX(x);
        this.surface.setBlockY(y);
    }

    /**
     * Return the name of the map
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Modify the name of the map
     * @param name the map name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Move all the block of the map
     * @param position decalage
     */
    public void move(BlockPosition position) {
        Enumeration<Block> list = blocks.elements();
        while(list.hasMoreElements()){
            Block b = list.nextElement();
            b.move(position);
        }
    }

    /**
     * Add blocks to the map
     * @param blocks the blocks to add
     */
    private void addBlocks(Vector<Block> blocks) {
        for(int i=0;i<blocks.size();i++){
            this.addBlock(blocks.elementAt(i));
        }
    }

}
