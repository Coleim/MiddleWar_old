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
    private Stack<Element> xmwpUpdatesList = new Stack();
    private Vector<String> xmwpMapWatchList = new Vector<String>();


    public Player(String id,Vector<String> unitsIds) {
        this.id = id;
        this.unitsIds = unitsIds;
    }

    public void addXMWPUpdate(Element e){
        xmwpUpdatesList.push(e);
    }

    public Stack<Element> getXmwpUpdates(){
        return xmwpUpdatesList;
    }

    public void addXmwpMapWatch(String name){
        xmwpMapWatchList.add(name);
    }

    public void removeXmwpMapWatch(String name){
        xmwpMapWatchList.remove(name);
    }

    public Vector<String> getXmwpMapWatch(){
        return xmwpMapWatchList;
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
