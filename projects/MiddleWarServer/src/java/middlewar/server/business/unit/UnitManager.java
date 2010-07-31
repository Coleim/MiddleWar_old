/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;
import middlewar.common.*;
import middlewar.server.managers.IUnitManager;
import middlewar.server.Server;
import middlewar.server.business.ai.BasicalIntelligence;
import middlewar.server.data.DAOUnit;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.*;
import middlewar.xmwp.XMWPException;
import middlewar.xmwp.elements.inform.MoveInformElement;

/**
 * Manage units
 * @author higurashi
 */
public class UnitManager implements IUnitManager {

    private final Object lock;          // concurent modifications lock
    private HashMap<String,Unit> units; // all units

    /**
     * Initialise the manager
     */
    public UnitManager() {
        Server.logs.logMainInfo("start UnitManager");
        units = new HashMap<String, Unit>();
        lock = new Object();
        Server.logs.logInfo("UnitManager started");
    }

    @Override
    public Unit getUnit(String id) throws ServerException{
        synchronized(lock){
            if(units.containsKey(id)){
                return units.get(id);
            }else{
                DAOUnit u = Server.dataManager.getUnit(id);
                units.put(id,new Unit(u));
                return units.get(id);
            }
        }
    }

    @Override
    public ArrayList<Unit> getUnits(String playerId) throws ServerException{
        ArrayList<Unit> list = new ArrayList<Unit>();
        synchronized(lock){
            for(Unit u : units.values()){
                if(u.getPlayerId().equals(playerId)) list.add(u);
            }
        }
        return list;
    }

    @Override
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

    @Override
    public void LoadAllUnits() throws ServerException {
        ArrayList<DAOUnit> list = Server.dataManager.getAllUnits();
        int size = list.size();
        synchronized(lock){
            for(int i=0;i<size;i++){
                Unit u = new Unit(list.get(i));
                units.put(u.getId(), u);
            }
        }

        Unit iaUnit = new Unit(new DAOUnit("AI__1", "AI", new BlockPosition(16,7), WorldName.valueOf("test1"), Orientation.DOWN ));

        BasicalIntelligence basicIntelligence = new BasicalIntelligence(iaUnit);
        iaUnit.setIntelligence(basicIntelligence);
        if ( !Server.aiEngine.addBasicalIntelligence(basicIntelligence) ) {
             throw new UnsupportedOperationException("Cannot add IA.");
        }
        units.put(iaUnit.getId(), iaUnit);
    }

    @Override
    public void LoadPlayerUnits(String playerId) throws ServerException{
        ArrayList<DAOUnit> list = Server.dataManager.getPlayerUnits(playerId);
        int size = list.size();
        synchronized(lock){
            for(int i=0;i<size;i++){
                Unit u = new Unit(list.get(i));
                units.put(u.getId(), u);
            }
        }
    }

    @Override
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

    @Override
    public String[] getMaps(Unit u) throws ServerException, WorldMakerException {
        World w = Server.worldManager.getWorldByName(u.getWorld());
        String[] mapsNames = w.getMapForPosition(u.getPosition());
        return mapsNames;
    }

    @Override
    public String getMainMap(Unit u) throws ServerException, WorldMakerException{
        String[] maps = getMaps(u);
        if(maps.length>0) return maps[0]; else throw new ServerException("no map found for unit "+u.getId());
    }

    @Override
    public void moveUnit(Unit unit, BlockPosition position, WorldName world) throws ServerException, XMWPException, WorldMakerException {
        unit.setPosition(position);
        unit.setWorld(world);
        String map = getMainMap(unit);
        Server.xmwpUpdateManager.addUpdateInMap(new MoveInformElement(unit.getId(), map, position.getBlockX(), position.getBlockY()), map);
    }

    @Override
    public void moveUnit(Unit unit, Orientation direction) throws ServerException, XMWPException, WorldMakerException{
        switch(direction){
            case DOWN: moveUnit(unit, unit.getPosition().down(), unit.getWorld()); break;
            case UP: moveUnit(unit, unit.getPosition().up(), unit.getWorld()); break;
            case RIGHT: moveUnit(unit, unit.getPosition().right(), unit.getWorld()); break;
            case LEFT: moveUnit(unit, unit.getPosition().left(), unit.getWorld()); break;
        }
    }
    
}