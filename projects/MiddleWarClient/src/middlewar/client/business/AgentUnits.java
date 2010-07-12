/*
 * Middle War - Client
 *
 */

package middlewar.client.business;

import java.util.Collection;
import middlewar.client.business.units.*;

/**
 * Board game agent
 * @author higurashi
 */
public class AgentUnits implements Agent{

    private UnitBoard units;

    private Unit selectedUnit;

    public AgentUnits(UnitBoard units) {
        this.units = units;
    }

      public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }


    public void addUnitSpeak(UnitSpeak us) {
        units.addSpeak(us);
    }

    public Collection<Unit> getUnits() {
        return units.getUnits().values();
    }

    
    public UnitBoard getUnitsBoard() {
        return units;
    }
    
    /**
     * @see GameAgent
     */
    public void stop(){ }

    /**
     * @see GameAgent
     */
    public void start() { }

    public Unit getUnit(int x, int y) {
        return this.units.getUnit(x, y);
    }

    public Unit getUnit(String unitid) {
        return units.getUnit(unitid);
    }

    public Collection<Unit> getUnitsAtSpeakRange(Unit source) {
        return units.getUnitsAtSpeakRange(source);
    }

    public void addUnit(Unit u) {
        units.addUnit(u);
    }
    
}
