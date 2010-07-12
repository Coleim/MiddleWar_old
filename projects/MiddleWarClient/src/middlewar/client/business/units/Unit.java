/*
 * Middle War - Client
 *
 */

package middlewar.client.business.units;

import java.util.Vector;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;

/**
 * Game unit
 * @author higurashi
 */
public class Unit {

    private Vector<UnitGraphicalPart> graphics;
    private int maxOrder;
    private Orientation orientation;
    private BlockPosition position;
    private String id;

    public Unit(String id) {
        graphics = new Vector<UnitGraphicalPart>();
        maxOrder = 0;
        this.id = id;
        position = new BlockPosition(0, 0);
        orientation = Orientation.DOWN;
    }

    public BlockPosition getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return "test";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(int x){
        this.position.setBlockX(x);
    }

    public void setY(int y){
        this.position.setBlockY(y);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }

    public void addGraphicalPart(String name,int rightOrder,int leftOrder,int upOrder,int downOrder){
        UnitGraphicalPart gp = new UnitGraphicalPart(name);
        
        gp.setDownOrder(downOrder);
        gp.setLeftOrder(leftOrder);
        gp.setUpOrder(upOrder);
        gp.setRightOrder(rightOrder);

        if(downOrder>maxOrder) maxOrder=downOrder;
        if(leftOrder>maxOrder) maxOrder=leftOrder;
        if(upOrder>maxOrder) maxOrder=upOrder;
        if(rightOrder>maxOrder) maxOrder=rightOrder;

        this.graphics.add(gp);
    }

    public Vector<UnitGraphicalPart> getGraphics() {
        return graphics;
    }

    

}
