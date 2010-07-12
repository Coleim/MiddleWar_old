/*
 * Middle War - Server
 *
 */

package middlewar.server.business.world;

import middlewar.common.BlockPosition;
import middlewar.common.MapPosition;
import middlewar.common.Orientation;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.Block;
import middlewar.server.worldmaker.business.BlockCollision;
import middlewar.server.worldmaker.business.Map;
import middlewar.server.worldmaker.business.World;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.business.WorldName;


/**
 * Manage worlds
 * @author higurashi
 */
public class WorldManager {

    public WorldManager() {}

    /**
     * Return a map by giving the map name
     * @param name the name of the map
     * @return the map
     * @throws ServerException
     */
    public Map getMapByName(String name) throws ServerException{
        return World.loadMap(name);
    }

    /**
     * Return a world by giving the world name
     * @param name the name of the world
     * @return the world
     * @throws ServerException
     */
    public World getWorldByName(WorldName name) throws ServerException{
        return World.loadWord(name);
    }

    public boolean canMoveUnitTo(Unit u, int x, int y) throws ServerException, WorldMakerException {
        boolean ret = true;
        World w = getWorldByName(u.getWorld());
        String[] mapsNames = w.getMapForPosition(u.getPosition());
        Map map = getMapByName(mapsNames[0]);
        for(int i=0;i<=5;i++){
            Block b = map.getBlock(new MapPosition(x,y, 0, i, mapsNames[0]));
            if(b!=null){
                if(b.getClass().equals(BlockCollision.class)){
                    BlockPosition p = u.getPosition();
                    if(p.down().equals(b.getPosition()) && ((BlockCollision)b).getOrientation()==Orientation.UP)  return false;
                    if(p.up().equals(b.getPosition()) && ((BlockCollision)b).getOrientation()==Orientation.DOWN)  return false;
                    if(p.left().equals(b.getPosition()) && ((BlockCollision)b).getOrientation()==Orientation.RIGHT)  return false;
                    if(p.right().equals(b.getPosition()) && ((BlockCollision)b).getOrientation()==Orientation.LEFT)  return false;
                }
                ret = b.isPassing();
            }
        }
        return ret;
    }

}