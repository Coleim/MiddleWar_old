/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

import java.io.Serializable;

/**
 * A surface
 * @author higurashi
 */
public abstract class Surface implements Serializable,Comparable<Surface>{

    private int x;
    private int y;
    
    public Surface(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getPxX() {
        return x;
    }

    public int getPxY() {
        return y;
    }

     public int getBlockX() {
        return x/Constants.blockPxSize;
    }

    public int getBlockY() {
        return y/Constants.blockPxSize;
    }

    public void setPxX(int x) {
        this.x = x;
    }

    public void setPxY(int y) {
        this.y = y;
    }

     public void setBlockX(int x) {
        this.x = x*Constants.blockPxSize;
    }

    public void setBlockY(int y) {
        this.y = y*Constants.blockPxSize;
    }

    public int compareTo(Surface s) {
        if(this.x==s.x && this.y==s.y) return 0; else return -1;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Surface) {
            if(this.compareTo((Surface)anObject) == 0) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Integer.parseInt(new String(x+"0"+y));
        return hash;
    }

    @Override
    public String toString() {
        return "("+this.x+"x"+this.y+")";
    }

}
