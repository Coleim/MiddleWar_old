/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.client.business.units;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.text.Position;
import middlewar.common.BlockPosition;

/**
 *
 * @author jonathan
 */
public class UnitBoard {

        private Hashtable<String,Unit> units;
        private Vector<UnitSpeak> speaks;

    public UnitBoard() {
        this.units = new Hashtable<String, Unit>();
        this.speaks = new Vector<UnitSpeak>();
        /*
        Unit u = new Unit("test");
        u.addGraphicalPart("m_1", 0, 0, 0, 0);
        u.setX(5);
        u.setY(5);
        units.put(u.getId(), u);
         */
        //UnitSpeak us = new UnitSpeak("COUCOU", u);
        //UnitSpeak us = new UnitSpeak(UnitSpeak.emoticon.happy, u);
        //us.setBackgroundColor(Color.WHITE);
        //us.setFontColor(Color.BLACK);
        //this.speaks.add(us);

        


    }

   
    public void addUnit(Unit u){
        units.put(u.getId(), u);
    }

   
    public Vector<UnitSpeak> getSpeaks() {
        return speaks;
    }

    public Unit getUnit(String unitid) {
        return units.get(unitid);
    }

    

    public Hashtable<String, Unit> getUnits() {
        return units;
    }

    public Unit getUnit(int x, int y) {
        for(String id : this.units.keySet()){
            if(this.units.get(id).getPosition().getBlockX() == x
               && this.units.get(id).getPosition().getBlockY() == y
              ){
                return this.units.get(id);
            }
        }
        return null;
    }


    public Unit getUnit(BlockPosition position) {
        for(String id : this.units.keySet()){
            if(this.units.get(id).getPosition().equals(position))
                return this.units.get(id);
        }
        return null;
    }

    public void removeSpeak(UnitSpeak speak) {
        this.speaks.remove(speak);
    }

    public void addSpeak(UnitSpeak speak) {
        this.speaks.add(speak);
    }

    public boolean unitExist(String id) {
        return units.containsKey(id);
    }

    public void removeUnit(String id) {
        units.remove(id);
    }

}
