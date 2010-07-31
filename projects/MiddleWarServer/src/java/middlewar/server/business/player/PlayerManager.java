/*
 * Middle War - Server
 *
 */

package middlewar.server.business.player;

import java.util.ArrayList;
import java.util.HashMap;
import middlewar.server.managers.IPlayerManager;
import middlewar.server.Server;
import middlewar.server.ServerSecurity;
import middlewar.server.business.unit.Unit;
import middlewar.server.data.DAOPlayer;
import middlewar.server.exception.ServerException;

/**
 * Manage players
 * @author higurashi
 */
public class PlayerManager implements IPlayerManager{

    public HashMap<String,Player> players;  // id -> player

    /**
     * Initialise the manager
     */
    public PlayerManager() {
        Server.logs.logMainInfo("start PlayerManager");
        players = new HashMap<String, Player>();
        Server.logs.logInfo("PlayerManager started");
    }

    @Override
    public Player getPlayerById(String id) throws ServerException{
        if(players.containsKey(id)){
            return players.get(id);
        }else{
            DAOPlayer p = Server.dataManager.getPlayer(id);
            players.put(id,new Player(p));
            return players.get(id);
        }
    }

    @Override
    public Player getPlayerByKey(String key) throws ServerException{
        return getPlayerById(ServerSecurity.getPlayerId(key));
    }

    @Override
    public Unit[] getPlayerUnits(Player player){
        return null;
    }

    @Override
    public ArrayList<String> getPlayerUnitsIds(Player player){
        return player.getUnitsIds();
    }

    @Override
    public Iterable<Player> getPlayersConnected() {
        return players.values();
    }

    @Override
    public void savePlayer(Player p) throws ServerException {
        //Server.dataManager.savePlayer(p);
        //Server.dataManager.saveUnits(Server.unitManager.getUnits(p.getId()));
    }

    @Override
    public void savePlayers() throws ServerException {
        for(Player p : players.values()){
            savePlayer(p);
        }
    }

}