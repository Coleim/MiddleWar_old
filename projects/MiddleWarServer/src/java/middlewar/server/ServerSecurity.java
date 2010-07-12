/*
 * Middle War - Server
 *
 */

package middlewar.server;

import java.util.Hashtable;
import middlewar.server.exception.ServerException;

/**
 * Manage security on server
 * @author higurashi
 */
public class ServerSecurity {

    // playerid => key
    public static Hashtable<String,String> keys = new Hashtable<String, String>();

    public static boolean islogged(String id){
        return keys.containsKey(id);
    }

    public static boolean verifyPassword(String login, String password) throws ServerException{
        return Server.dataManager.verifyPlayerPassword(login, password);
    }

    public static String getNewPlayerKey(String id){
        if(keys.containsKey(id)){
            return keys.get(id);
        }
        else{
            String spc = "MWSC"+String.valueOf(Math.round(Math.random()*10000000))+id;
            keys.put(id, spc);
            return spc;
        }
    }

    public static String getPlayerId(String key) throws ServerException{

        if(!keys.containsValue(key)){
            throw new ServerException("no player for key="+key+", not logged in ?");
        }

        for(String id : keys.keySet()){
            if(keys.get(id).equals(key)) return id;
        }

        return null;
    }

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
