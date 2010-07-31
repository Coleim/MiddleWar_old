/*
 * Middle War - Server
 *
 */

package middlewar.server.managers;

import java.util.ArrayList;
import java.util.Stack;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;
import middlewar.server.business.unit.*;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.Block;
import middlewar.server.worldmaker.business.Map;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.business.WorldName;
import middlewar.xmwp.XMWPException;

/**
 * Manage units
 * @author Higurashi
 */
public interface IUnitManager extends IManager{

    /**
     * Return the unit with the specified id
     * @param id the id of the unit
     * @return the unit object
     * @throws ServerException
     */
    public Unit getUnit(String id) throws ServerException;

    /**
     * Return a set of units for a specified player id
     * @param playerId the player id
     * @return all the units of the player
     * @throws ServerException
     */
    public ArrayList<Unit> getUnits(String playerId) throws ServerException;

    /**
     * Return all the units located in a specified map
     * @param map the map where are the units
     * @return all the unit in the map
     * @throws ServerException
     * @throws WorldMakerException
     */
    public ArrayList<Unit> getUnitsInMap(Map  map) throws ServerException, WorldMakerException;

    /**
     * Return all the units that are close to a specified unit
     * @param source the unit speaking
     * @return all the units that can hear the unit
     */
    public Stack<Unit> getUnitsAtSpeakRange(Unit source);


    /**
     * Load all the units from the database
     * @throws ServerException
     */
    public void LoadAllUnits() throws ServerException;

    /**
     * Load all units from the database for a specified player
     * @param playerId the id of the player
     * @throws ServerException
     */
    public void LoadPlayerUnits(String playerId) throws ServerException;

    /**
     * Move a unit
     * @param unitId the id of the unit to move
     * @param position the position in the world
     * @param world the name of the world
     */
    public void moveUnit(Unit unit, BlockPosition position, WorldName world) throws ServerException, XMWPException, WorldMakerException;

    /**
     * Move a unit in a specified direction
     * @param unitId the id of the unit to move
     * @param direction the direction of the move
     */
    public void moveUnit(Unit unit, Orientation direction) throws ServerException, XMWPException, WorldMakerException;

    /**
     * Return all the maps linked to the position of an unit
     * @param u the unit
     * @return the name of all maps
     * @throws ServerException
     * @throws WorldMakerException
     */
    public String[] getMaps(Unit u) throws ServerException, WorldMakerException;

    /**
     * Return the map name of the localisation of an unit
     * @param u the unit
     * @return the main map name
     * @throws ServerException
     * @throws WorldMakerException
     */
    public String getMainMap(Unit u) throws ServerException, WorldMakerException;

}
