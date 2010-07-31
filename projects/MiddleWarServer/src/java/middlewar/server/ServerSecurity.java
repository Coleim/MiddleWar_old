/*
 * Middle War - Server
 *
 */

package middlewar.server;

import java.util.HashMap;
import middlewar.server.exception.ServerException;

/**
 * Manage security on the  server
 * @author higurashi
 */
public class ServerSecurity {

    // playerid => key
    public static HashMap<String,String> keys = new HashMap<String, String>();

    /**
     * tell if a player is already logged
     * @param id the player id
     * @return true if the player is logged
     */
    public static boolean islogged(String id){
        return keys.containsKey(id);
    }

    /**
     * Verify a password
     * @param login the player login
     * @param password the passord
     * @return true if the password is ok
     * @throws ServerException
     */
    public static boolean verifyPassword(String login, String password) throws ServerException{
        return Server.dataManager.verifyPlayerPassword(login, password);
    }

    /**
     * Return a security key for a player
     * @param id the player id
     * @return a security key
     */
    public static String getNewPlayerKey(String id){
        if(keys.containsKey(id)){
            return keys.get(id);
        }
        else{
            String spc = "XXXX"+String.valueOf(Math.round(Math.random()*10000000))+id;
            keys.put(id, spc);
            Server.logs.logInfo("generating new key ("+spc+") for player : "+id);
            return spc;
        }
    }

    /**
     * Return a player id by giving a
     * @param key the security key
     * @return the player id
     * @throws ServerException
     */
    public static String getPlayerId(String key) throws ServerException{
        if(!keys.containsValue(key)){
            throw new ServerException("no player for key="+key+", not logged in ?");
        }
        for(String id : keys.keySet()){
            if(keys.get(id).equals(key)) return id;
        }
        return null;
    }

    /**
     * Return a existing security key for a specified player
     * @param id the player id
     * @return the security key
     */
    public static String getPlayerKey(String id){
        if(id == null) return null;
        if(!keys.containsKey(id)){
            return null;
        }
        else{
            return keys.get(id);
        }
    }

}
