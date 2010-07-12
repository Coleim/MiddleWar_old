/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import java.util.ArrayList;
import java.util.Collection;
import middlewar.server.business.player.*;
import java.util.Hashtable;
import java.util.Stack;
import middlewar.common.BlockPosition;
import middlewar.common.BlockSurface;
import middlewar.common.Position;
import middlewar.server.Server;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.Map;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Manage units
 * @author higurashi
 */
public class UnitManager {

    private final Object lock = new Object();
    private Hashtable<String,Unit> units = new Hashtable<String, Unit>();

    public UnitManager() {}

    public Unit getUnit(String id) throws ServerException{
        synchronized(lock){
            if(units.containsKey(id)){
                return units.get(id);
            }else{
                Unit u = Server.dataManager.getUnit(id);
                units.put(id,u);
                return units.get(id);
            }
        }
    }

    public ArrayList<Unit> getUnitsInMap(Map  map) throws ServerException, WorldMakerException {
        ArrayList<Unit> list = new ArrayList<Unit>();
        synchronized(lock){
            
            for(Unit u : units.values()){
                String[] m = Server.worldManager.getWorldByName(u.getWorld()).getMapForPosition(u.getPosition());
                if(m[0].equals(map.getName())) list.add(u);
            }
            
        }
        return list;
    }

    public void LoadAllUnits() throws ServerException {
        ArrayList<Unit> list = Server.dataManager.getAllUnits();
        int size = list.size();
        synchronized(lock){
            for(int i=0;i<size;i++){
                Unit u = list.get(i);
                units.put(u.getId(), u);
            }
        }
    }

    public Stack<Unit> getUnitsAtSpeakRange(Unit source) {
        BlockSurface area = new BlockSurface(15, 15);
        Stack<Unit> result = new Stack<Unit>();
        synchronized(lock){
            Collection<Unit> list = units.values();
            for(Unit u : list){
                BlockPosition base = source.getPosition().add(new BlockPosition(-(area.getBlockX()/2), -(area.getBlockY()/2)));
                BlockPosition p = u.getPosition().relativeTo(base);
                if(p.getBlockX()<area.getBlockX() && p.getBlockY()<area.getBlockY() && !source.getId().equals(u.getId())){
                    result.add(u);
                }

            }
            return result;
        }
    }

}