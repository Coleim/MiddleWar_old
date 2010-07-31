/*
 * Middle War - Server
 *
 */

package middlewar.server.managers;

import java.util.ArrayList;
import middlewar.server.data.*;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Manage data
 * @author Higurashi
 */
public interface IDataManager extends IManager{

    /**
     * Get an user from database
     * @param id the player id
     */
    public DAOPlayer getPlayer(String id) throws ServerException;

    /**
     * Verify a player password
     * @param id the player id
     */
    public boolean verifyPlayerPassword(String id,String password) throws ServerException;

    /**
     * Get units owned by a player
     * @param id the player id
     */
    public ArrayList<DAOUnit> getPlayerUnits(String id) throws ServerException;

    /**
     * Get units ids owned by a player
     * @param id the player id
     */
    public ArrayList<String> getPlayerUnitsIds(String id) throws ServerException;

    /**
     * Get all units in a specified world
     * @param id the player id
     */
    public ArrayList<DAOUnit> getWorldUnits(WorldName worldName) throws ServerException;

    /**
     * Return a unit by giving his id
     * @param id the unit id
     * @return the unit object
     * @throws ServerException
     */
    public DAOUnit getUnit(String id) throws ServerException;

    /**
     * Return all units in the database
     * @return all units
     * @throws ServerException
     */
    public ArrayList<DAOUnit> getAllUnits() throws ServerException;

    /**
     * Save a player in the database
     * @param p the player to save
     */
    public void savePlayer(DAOPlayer p);

    /**
     * Save untis in the database
     * @param units the units to save
     */
    public void saveUnits(ArrayList<DAOUnit> units);

}
