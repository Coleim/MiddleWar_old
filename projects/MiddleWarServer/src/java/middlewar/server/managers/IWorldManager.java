/*
 * Middle War - Server
 *
 */

package middlewar.server.managers;

import middlewar.server.business.unit.*;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.Map;
import middlewar.server.worldmaker.business.World;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Manage worlds
 * @author Higurashi
 */
public interface IWorldManager extends IManager{
    
    /**
     * Return a map by giving the map name
     * @param name the name of the map
     * @return the map
     * @throws ServerException
     */
    public Map getMapByName(String name) throws ServerException;

    /**
     * Return a world by giving the world name
     * @param name the name of the world
     * @return the world
     * @throws ServerException
     */
    public World getWorldByName(WorldName name) throws ServerException;

    /**
     * Tell if an unit is able to move to a position
     * @param u the unit to move
     * @param x the x position
     * @param y the y position
     * @return true if unit can move , else false
     * @throws ServerException
     * @throws WorldMakerException
     */
    public boolean canMoveUnitTo(Unit u, int x, int y) throws ServerException, WorldMakerException;

}
