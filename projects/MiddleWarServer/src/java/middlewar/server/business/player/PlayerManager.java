/*
 * Middle War - Server
 *
 */

package middlewar.server.business.player;

import java.util.Hashtable;
import middlewar.server.Server;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;

/**
 * Manage players
 * @author higurashi
 */
public class PlayerManager {

    public Hashtable<String,Player> players;

    public PlayerManager() {
        players = new Hashtable<String, Player>();
    }

    public Player getPlayer(String id) throws ServerException{
        if(players.containsKey(id)){
            return players.get(id);
        }else{
            Player p = Server.dataManager.getPlayer(id);
            players.put(id,p);
            return players.get(id);
        }
    }

    public Unit[] getPlayerUnits(Player player){
        return null;
    }

    public String[] getPlayerUnitsIds(Player player){
        return player.getUnitsIds();
    }


}