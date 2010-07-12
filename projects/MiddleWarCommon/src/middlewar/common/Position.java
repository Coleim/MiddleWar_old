/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

import java.io.Serializable;

/**
 * A position
 * @author higurashi
 */
public abstract class Position implements Serializable,Comparable<Position>{

    protected int x;
    protected int y;

    public Position add(Position position) {
        Position p = new PxPosition(this.x,this.y);
        p.x += position.x;
        p.y += position.y;
        return p;
    }

    public Position(int x, int y) {
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
        return x/Constains.blockPxSize;
    }

    public int getBlockY() {
        return y/Constains.blockPxSize;
    }

    public void setPxX(int x) {
        this.x = x;
    }

    public void setPxY(int y) {
        this.y = y;
    }

     public void setBlockX(int x) {
        this.x = x*Constains.blockPxSize;
    }

    public void setBlockY(int y) {
        this.y = y*Constains.blockPxSize;
    }

    public int compareTo(Position p) {
        if(this.x==p.x && this.y==p.y) return 0; else return -1;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Position) {
            if(this.compareTo((Position)anObject) == 0) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Integer.parseInt(new String(x+"0"+y).replace("-", ""));
        return hash;
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }

}
