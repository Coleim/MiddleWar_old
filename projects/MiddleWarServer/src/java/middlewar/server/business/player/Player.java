/*
 * Middle War - Server
 *
 */

package middlewar.server.business.player;

import java.util.ArrayList;
import java.util.Stack;
import middlewar.server.data.DAOPlayer;
import middlewar.xmwp.Element;

/**
 * Player
 * @author higurashi
 */
public class Player {

    private String id;                                                      // the player id
    private ArrayList<String> unitsIds;                                     // the units of the player
    private String selectedUnitId = null;                                   // the selected (played) unit
    private Stack<Element> xmwpUpdatesList = new Stack();                   // XMWP updates
    private ArrayList<String> xmwpMapWatchList = new ArrayList<String>();   // Maps watched

    /**
     * Create a new player
     * @param id the id of the player
     * @param unitsIds the units of the player
     */
    private Player(String id,ArrayList<String> unitsIds) {
        this.id = id;
        this.unitsIds = unitsIds;
    }

    /**
     * Create a player from a DAO
     * @param player the DAO player
     */
    public Player(DAOPlayer player) {
        this(player.getId(),player.getUnitsIds());
    }

    /**
     * Add a XMWP update to send to the player
     * @param e the WMXP element to add
     */
    public void addXMWPUpdate(Element e){
        xmwpUpdatesList.push(e);
    }

    /**
     * Get XMWP updates in stack
     * @return the XMWP elements
     */
    public Stack<Element> getXmwpUpdates(){
        return xmwpUpdatesList;
    }

    /**
     * Watch a map (receive XMWP updates linked to this map)
     * @param name the map name
     */
    public void addXmwpMapWatch(String name){
        xmwpMapWatchList.add(name);
    }

    /**
     * Stop watching a map
     * @param name the map name
     */
    public void removeXmwpMapWatch(String name){
        xmwpMapWatchList.remove(name);
    }

    /**
     * Return all maps watched by the player
     * @return the list of map names
     */
    public ArrayList<String> getXmwpMapWatch(){
        return xmwpMapWatchList;
    }

    /**
     * Return all the units id linked with the player
     * @return the list of units id
     */
    public ArrayList<String> getUnitsIds() {
        return unitsIds;
    }

    /**
     * @return the id of the player
     */
    public String getId() {
        return this.id;
    }

    /**
     * Return the id of the unit selected by the player
     * @return the id of the selected unit
     */
    public String getSelectedUnitId() {
        return selectedUnitId;
    }

    /**
     * Modify the unit selected by the player
     * @param selectedUnitId the id of the selected unit
     */
    public void setSelectedUnitId(String selectedUnitId) {
        this.selectedUnitId = selectedUnitId;
    }

}
