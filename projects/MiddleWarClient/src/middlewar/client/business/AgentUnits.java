/*
 * Middle War - Client
 *
 */

package middlewar.client.business;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;
import middlewar.client.business.units.*;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;

/**
 * Board game agent
 * @author higurashi
 */
public class AgentUnits extends AbstractAgent{

    private UnitBoard units;
    private Unit selectedUnit;

    /*
     * Agent management methods
     */

    private static AgentUnits instance = null;

    public static AgentUnits getInstance() throws ClientException{
        if(instance == null) throw new ClientException("AgentUnits not initialized (call init())");
        return instance;
    }

    public static void init() throws ClientException {
        instance = new AgentUnits();
    }

    private AgentUnits() {
        this.units = new UnitBoard();
    }


    /*
     * AbstractAgent methods implementation
     */

    @Override
    public void addUnit(Unit u) throws ClientException{
        this.units.addUnit(u);
    }

    @Override
    public void modifyUnit(Unit u) throws ClientException {
        this.units.addUnit(u);
    }

    @Override
    public void deleteUnit(String id) throws ClientException {
        if(unitExist(id)) this.units.removeUnit(id);
    }

    @Override
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        /*
        Unit u = Game.getAgentUnits().getUnit(mapPosition);
        if(u != null){
            if(u.getPlayerId().equals(Game.getInstance().getPlayerId())) {
                this.setSelectedUnit(units.getUnit(mapPosition));
            }
        }
        */
    }

    /*
     * Business methods
     */

    private void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void addUnitSpeak(UnitSpeak us) {
        units.addSpeak(us);
    }

    public Hashtable<String, Unit> getUnits() {
        return units.getUnits();
    }

    public Vector<UnitSpeak> getSpeaks() {
        return units.getSpeaks();
    }

    public Unit getUnit(int x, int y) {
        return this.units.getUnit(x, y);
    }

    public Unit getUnit(String unitid) {
        return units.getUnit(unitid);
    }

    public Unit getUnit(BlockPosition mapPosition) {
        return getUnit(mapPosition.getBlockX(), mapPosition.getBlockY());
    }

    public boolean unitExist(String id) {
        return units.unitExist(id);
    }

    public void setFocus(Unit u) {
        setSelectedUnit(u);
    }


    
    
}
