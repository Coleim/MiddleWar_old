/*
 * Middle War - Server
 *
 */

package middlewar.server.business.world;

import java.util.EnumMap;
import middlewar.common.*;
import middlewar.server.Server;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.*;
import middlewar.server.managers.IWorldManager;

/**
 * Manage worlds
 * @author higurashi
 */
public class WorldManager implements IWorldManager{

    private EnumMap<WorldName,World> worldsCaching;

    /**
     * Initialise the manager
     */
    public WorldManager() {
        Server.logs.logMainInfo("start WorldManager");
        worldsCaching = new EnumMap<WorldName, World>(WorldName.class);
        Server.logs.logInfo("WorldManager started");
    }

    @Override
    public Map getMapByName(String name) throws ServerException{
        Server.logs.logInfo("[WorldManager] getMapByName "+name);
        return World.loadMap(name);
    }

    @Override
    public World getWorldByName(WorldName name) throws ServerException{
        World obj = worldsCaching.get(name);
        if(obj == null){
            obj = World.loadWord(name);
            worldsCaching.put(name, obj);
        }
        return obj;
    }

    @Override
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