/*
 * Middle War - Server
 *
 */

package middlewar.server.data;

import java.util.ArrayList;

/**
 * Player DAO
 * @author Higurashi
 */
public class DAOPlayer implements DAO{

    private String id;
    private ArrayList<String> unitsIds;

    public DAOPlayer(String id, ArrayList<String> unitsIds) {
        this.id = id;
        this.unitsIds = unitsIds;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getUnitsIds() {
        return unitsIds;
    }

}
