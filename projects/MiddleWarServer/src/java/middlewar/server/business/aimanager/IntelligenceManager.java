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

    private List<ArtificialIntelligence> aiList = new ArrayList<ArtificialIntelligence>();
    private boolean running = false;

    private final Object lock;

    public IntelligenceManager() {
        lock = new Object();
    }

    @Override
    public void run() {

        running = true;
        
        while( running ) {
            synchronized(lock) {
                for (ArtificialIntelligence artificialIntelligence : aiList) {
                   artificialIntelligence.live();
                }
            }

            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }

    public boolean addIntelligence(ArtificialIntelligence intelligence) {
        boolean addIASuccess = false;

        if( !aiList.contains(intelligence) ) {
            synchronized(lock) {
                aiList.add(intelligence);
            }
            addIASuccess = true;
        }
        return addIASuccess;
    }
        
}
