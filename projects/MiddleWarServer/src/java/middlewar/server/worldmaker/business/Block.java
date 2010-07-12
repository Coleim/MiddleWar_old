/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.Block.java
 *
 * History :
 * 1.0     : Add to wm, basic fonctions
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.xmwp.elements.inform.BlockInformElement;
import middlewar.common.*;
import middlewar.xmwp.*;
import middlewar.xmwp.elements.*;

import java.io.Serializable;
import java.util.Vector;

/**
 * Base element of maps
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class Block implements Serializable,XMWPable {

    protected MapPosition position;                     // position of block
    protected BlockType type = BlockType.dev_unknown;   // type of the block
    protected boolean passing;          // true if it's possible to pass over
                                        // the block

    /**
     * Block constructor
     * @param position the position of the block (in world object)
     * @param type the type of the block
     * @param passing true if it's possible to pass over the block
     */
    public Block(MapPosition position, BlockType type, boolean passing) {
        this.position = position;
        /*if(type == null) this.type=BlockType.dev_unknown; else*/ this.type = type;
        this.passing = passing;
    }

    /**
     * True if it's possible to pass over the block
     * @return True or False
     */
    public boolean isPassing() {
        return this.passing;
    }

    /**
     * Modify the type of the block
     * @param type the new type
     */
    public void setType(BlockType type) {
        this.type = type;
        /*if(type == null) this.type=BlockType.dev_unknown;*/
    }

    /**
     * Return the type of the block
     * @return the type of the block
     */
    public BlockType getType() {
        return type;
    }

    /**
     * Return the position of the block
     * @return the position of the block
     */
    public MapPosition getPosition() {
        return position;
    }

    /**
     * Modify the position of the block
     * @param position the position of the block
     */
    public void setPosition(MapPosition position) {
        this.position = position;
    }

    /**
     * Modify the position of the block by adding another position
     * @param position the position modifier
     */
    public void move(BlockPosition position) {
        this.position = this.position.add(position);
    }

    /**
     * Tell if a set of blocks are all passables
     * @param blocks the set of blocks to test
     * @return True if they are all passables
     */
    public static boolean arePassable(Vector<Block> blocks) {
        if(blocks == null) return false;
        boolean result = false;
        if(blocks != null && blocks.size() >= 1 && blocks.elementAt(blocks.size()-1) != null){

            if(blocks.elementAt(blocks.size()-1).getClass().equals(BlockCollision.class ))
                result = blocks.elementAt(blocks.size()-2).isPassing();
            else
                result = blocks.elementAt(blocks.size()-1).isPassing();
        //for(int i=0;i<blocks.size();i++) {
        //    if(!blocks.elementAt(i).isPassing()) return false;
        //}
        }
        return result;
    }

    /**
     * @see XMWPable
     */
    public Element getXMWPElement() throws XMWPException {

        if(type == null) return null;

        return new BlockInformElement(position.getMap(),
        type.getShortPathImage(),position.getBlockX(),
        position.getBlockY(),position.getOrder(),
        position.getLayer(),passing);
    }
    
}
