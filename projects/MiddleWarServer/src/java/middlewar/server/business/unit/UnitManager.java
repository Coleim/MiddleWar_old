/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import middlewar.server.business.player.*;
import java.util.Hashtable;
import middlewar.server.Server;
import middlewar.server.exception.ServerException;

/**
 * Manage units
 * @author higurashi
 */
public class UnitManager {

    public Hashtable<String,Unit> units = new Hashtable<String, Unit>();

    public UnitManager() {
    }

    public Unit getUnit(String id) throws ServerException{
        if(units.containsKey(id)){
            return units.get(id);
        }else{
            Unit u = Server.dataManager.getUnit(id);
            units.put(id,u);
            return units.get(id);
        }
    }


}