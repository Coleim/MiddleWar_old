/*
 * Middle War - Server
 *
 */

package middlewar.server.business.player;

import java.util.Stack;
import java.util.Vector;
import middlewar.server.Server;
import middlewar.xmwp.Element;

/**
 * Game player
 * @author higurashi
 */
public class Player {

    private String id;
    private Vector<String> unitsIds;
    private Stack<Element> xmwpUpdates = new Stack();


    public Player(String id,Vector<String> unitsIds) {
        this.id = id;
        this.unitsIds = unitsIds;
    }

    public void addXMWPUpdate(Element e){
        xmwpUpdates.push(e);
    }

    public Stack<Element> getXmwpUpdates(){
        return xmwpUpdates;
    }

    public String[] getUnitsIds() {
        return unitsIds.toArray(new String[unitsIds.size()]);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
