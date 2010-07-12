/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

/**
 * @see Surface
 * @author higurashi
 */
public class BlockSurface extends Surface{

    public BlockSurface(int x, int y) {
        super(x*Constains.blockPxSize, y*Constains.blockPxSize);
    }

}
