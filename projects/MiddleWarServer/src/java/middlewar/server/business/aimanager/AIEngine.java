/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.server.business.aimanager;

import middlewar.server.business.ai.BasicalIntelligence;
import middlewar.server.business.aimanager.IntelligenceManager;

/**
 *
 * @author coleim
 */
public class AIEngine {

    private IntelligenceManager basicalAIManager;

    public AIEngine() {
        basicalAIManager = new IntelligenceManager();

        basicalAIManager.start();
    }

    public boolean addBasicalIntelligence(BasicalIntelligence intelligence) {
        //TODO: Check the thread safety ! Mutex etc ...

        return basicalAIManager.addIntelligence(intelligence);
    }
}
