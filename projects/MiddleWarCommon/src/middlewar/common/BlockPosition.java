/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

/**
 * @see Position
 * @author higurashi
 */
public class BlockPosition extends Position{

    public static final BlockPosition origin = new BlockPosition(0, 0);

    public BlockPosition(int x, int y) {
        super(x*Constains.blockPxSize, y*Constains.blockPxSize);
    }

    public BlockPosition add(BlockPosition position) {
        BlockPosition p = new BlockPosition(this.getBlockX(),this.getBlockY());
        p.x += position.x;
        p.y += position.y;
        return p;
    }

    public BlockPosition(BlockPosition source, BlockPosition modifier) {
        super((source.getBlockX()-modifier.getBlockX())*Constains.blockPxSize,
              (source.getBlockY()-modifier.getBlockY())*Constains.blockPxSize);
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
        return new BlockPosition((this.x+Constains.blockPxSize)/Constains.blockPxSize, this.y/Constains.blockPxSize);
    }

    public BlockPosition left(){
        return new BlockPosition((this.x-Constains.blockPxSize)/Constains.blockPxSize, this.y/Constains.blockPxSize);
    }

    public BlockPosition up(){
        return new BlockPosition(this.x/Constains.blockPxSize, (this.y-Constains.blockPxSize)/Constains.blockPxSize);
    }

    public BlockPosition down(){
        return new BlockPosition(this.x/Constains.blockPxSize, (this.y+Constains.blockPxSize)/Constains.blockPxSize);
    }

    public BlockPosition relativeTo(BlockPosition position) {
        return new BlockPosition(this, position);
    }

}

