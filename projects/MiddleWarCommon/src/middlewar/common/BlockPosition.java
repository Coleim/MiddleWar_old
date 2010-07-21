/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

/**
 * The position expressed in block.
 * @see Position
 * @author higurashi
 */
public class BlockPosition extends Position{

    /**
     * The origin of a block position (0,0).
     */
    public static final BlockPosition origin = new BlockPosition(0, 0);

    /**
     * Default constructor.
     * Create a new block from the x and y position in cells.
     * @param x
     * @param y
     */
    public BlockPosition(int x, int y) {
        super(x*Constants.blockPxSize, y*Constants.blockPxSize);
    }

    private BlockPosition(BlockPosition source, BlockPosition modifier) {
        super((source.getBlockX()-modifier.getBlockX())*Constants.blockPxSize,
              (source.getBlockY()-modifier.getBlockY())*Constants.blockPxSize);
    }


    public BlockPosition add(BlockPosition position) {
        BlockPosition p = new BlockPosition(this.getBlockX(),this.getBlockY());
        p.x += position.x;
        p.y += position.y;
        return p;
    }

    public boolean in(BlockSurface surface) {
        boolean isIn = true;
        if(surface.getBlockX() <= this.getBlockX()) isIn = false;
        if(surface.getBlockY() <= this.getBlockY()) isIn = false;
        if(0 > this.getBlockX()) isIn = false;
        if(0 > this.getBlockY()) isIn = false;
        return isIn;
    }

    public BlockPosition right(){
        return new BlockPosition((this.x+Constants.blockPxSize)/Constants.blockPxSize, this.y/Constants.blockPxSize);
    }

    public BlockPosition left(){
        return new BlockPosition((this.x-Constants.blockPxSize)/Constants.blockPxSize, this.y/Constants.blockPxSize);
    }

    public BlockPosition up(){
        return new BlockPosition(this.x/Constants.blockPxSize, (this.y-Constants.blockPxSize)/Constants.blockPxSize);
    }

    public BlockPosition down(){
        return new BlockPosition(this.x/Constants.blockPxSize, (this.y+Constants.blockPxSize)/Constants.blockPxSize);
    }

    public BlockPosition relativeTo(BlockPosition position) {
        return new BlockPosition(this, position);
    }

}

