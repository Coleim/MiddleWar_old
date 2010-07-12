/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import middlewar.common.Orientation;

/**
 * A set of visual parts (for units)
 * @author higurashi
 */
public class PartImagesSet {

    public final PartImage up;
    public final PartImage down;
    public final PartImage right;
    public final PartImage left;

    public PartImagesSet(PartImage up, PartImage down, PartImage right, PartImage left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    public PartImage getDown() {
        return down;
    }

    public PartImage getLeft() {
        return left;
    }

    public PartImage getRight() {
        return right;
    }

    public PartImage getUp() {
        return up;
    }

    public PartImage get(Orientation orientation) {
        switch(orientation){
            case UP : return this.getUp();
            case DOWN : return this.getDown();
            case RIGHT : return this.getRight();
            case LEFT : return this.getLeft();
            default: return this.getDown();
        }
    }

}
