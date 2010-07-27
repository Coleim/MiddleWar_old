/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.server.business.ai;

import middlewar.server.business.unit.Unit;

/**
 *
 * @author coleim
 */
public abstract class ArtificialIntelligence {

    private boolean active;
    protected Unit parentUnit;
    
    public ArtificialIntelligence(Unit parentUnit) {
        this.parentUnit = parentUnit;
    }

    public abstract void live();

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
