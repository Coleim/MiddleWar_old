/*
 * Middle War - Server
 *
 */

package middlewar.server.data;

import middlewar.common.BlockPosition;
import middlewar.common.Orientation;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Unit DAO
 * @author Jonathan
 */
public class DAOUnit implements DAO{

    private String id;
    private String playerId = null;
    private BlockPosition position;
    private WorldName world;
    private Orientation orientation;

    public DAOUnit(String id,String playerId, BlockPosition position, WorldName world, Orientation orientation) {
        this.id = id;
        this.position = position;
        this.world = world;
        this.orientation = orientation;
        this.playerId = playerId;
    }

    public String getId() {
        return id;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getPlayerId() {
        return playerId;
    }

    public BlockPosition getPosition() {
        return position;
    }

    public WorldName getWorld() {
        return world;
    }

}
