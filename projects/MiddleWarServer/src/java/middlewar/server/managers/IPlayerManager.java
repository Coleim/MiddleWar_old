/*
 * Middle War - Server
 *
 */

package middlewar.server.managers;

import java.util.ArrayList;
import middlewar.server.business.player.*;
import middlewar.server.business.unit.*;
import middlewar.server.exception.ServerException;

/**
 * Manage players
 * @author Higurashi
 */
public interface IPlayerManager extends IManager{

    /**
     * Return a player identified by his id
     * @param id the player id
     * @return the player object
     * @throws ServerException
     */
    public Player getPlayerById(String id) throws ServerException;

    /**
     * Return a player identified by his key (see security)
     * @param key the security key
     * @return the player object
     * @throws ServerException
     */
    public Player getPlayerByKey(String key) throws ServerException;

    /**
     * Return all the units owned by a player
     * @param player the player
     * @return the units
     */
    public Unit[] getPlayerUnits(Player player);

    /**
     * Return all the ids of units owned by a player
     * @param player the player
     * @return the ids
     */
    public ArrayList<String> getPlayerUnitsIds(Player player);

    /**
     * Return all connected players
     * @return all connected players
     */
    public Iterable<Player> getPlayersConnected();

    /**
     * Save a player state
     * @param p the player to save
     * @throws ServerException
     */
    public void savePlayer(Player p) throws ServerException;

    /**
     * Save all players status
     * @throws ServerException
     */
    public void savePlayers() throws ServerException;

}
