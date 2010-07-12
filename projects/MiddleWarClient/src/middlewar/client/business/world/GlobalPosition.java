

package middlewar.client.business.world;

import middlewar.common.BlockPosition;

public class GlobalPosition {

    private BlockPosition bp;
    private String world;

    public GlobalPosition(BlockPosition position, String world) {
        this.bp = position;
        this.world = world;
    }

    public BlockPosition getBp() {
        return bp;
    }

    public void setBp(BlockPosition bp) {
        this.bp = bp;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }




}
