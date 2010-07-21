/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.server.business.aimanager;

import java.util.ArrayList;
import java.util.List;
import middlewar.server.business.ai.ArtificialIntelligence;

/**
 *
 * @author coleim
 */
public class IntelligenceManager extends Thread {


    protected List<ArtificialIntelligence> aiList = new ArrayList<ArtificialIntelligence>();


    public IntelligenceManager() {
        
    }

    @Override
    public void run() {
        for (ArtificialIntelligence artificialIntelligence : aiList) {
           artificialIntelligence.live();
        }
    }

    public boolean addIntelligence(ArtificialIntelligence intelligence) {
        boolean addIASuccess = false;

        if( !aiList.contains(intelligence) ) {
            aiList.add(intelligence);
            addIASuccess = true;
        }

        return addIASuccess;
    }
    
    
    
}
