/*
 * Middle War - Server
 *
 */

package middlewar.server;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;
import middlewar.server.business.player.Player;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Acces à la base de donnée (access layer)
 * base de donnée MySQL: 5.0
 * @author higurashi
 */
public class DataManager {

    private final Object lock = new Object();

    private com.mysql.jdbc.Connection link;
    private String myURL = "jdbc:mysql://127.0.0.1/mw"; //"jdbc:mysql://goblink.kicks-ass.net/mw";
    private String myLogin = "root"; //"mw";
    private String myPwd = "mysql"; //"mwpassw";

    public DataManager(){
        try {
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    		link = (Connection) DriverManager.getConnection(myURL,myLogin,myPwd);
    	} catch (SQLException e) {
            e.printStackTrace();
    	}
    }

    /**
     * Get an user from database
     * @param id the player id
     */
    public Player getPlayer(String id) throws ServerException{
        synchronized(lock){
            Player player = null;
            Statement query;
            ResultSet answer;
            String sql = "SELECT * FROM `players` WHERE playerId='"+id+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                if (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        player = new Player(answer.getString("playerId"),this.getPlayerUnitsIds(id));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return player;
        }
    }

    /**
     * Verify a player password
     * @param id the player id
     */
    public boolean verifyPlayerPassword(String id,String password) throws ServerException{
        synchronized(lock){
            boolean result = false;
            Statement query;
            ResultSet answer;
            String sql = "SELECT count(*) FROM `players` WHERE playerId='"+id+"' AND playerPassword='"+password+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                if (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        if(answer.getInt("count(*)")>=1) result = true;
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * Get units
     *
     */
    public Vector<Unit> getPlayerUnits(String id) throws ServerException{
        synchronized(lock){
            Vector<Unit> units = new Vector<Unit>();
            Statement query;
            ResultSet answer;
            String sql = "SELECT * FROM `units` WHERE playerId='"+id+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                while (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        units.add(new Unit(answer.getString("unitId"),
                                           id,
                                           new BlockPosition(answer.getInt("x"),answer.getInt("y")),
                                           WorldName.valueOf(answer.getString("world")),
                                           Orientation.DOWN
                                ));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return units;
        }
    }

    /**
     * Get units
     *
     */
    public Vector<String> getPlayerUnitsIds(String id) throws ServerException{
        synchronized(lock){
            Vector<String> units = new Vector<String>();
            Statement query;
            ResultSet answer;
            String sql = "SELECT unitId FROM `units` WHERE playerId='"+id+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                while (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        units.add(answer.getString("unitId"));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return units;
        }
    }


    public Vector<Unit> getWorldUnit(WorldName worldName) throws ServerException {
        synchronized(lock){
            Vector<Unit> units = new Vector<Unit>();
            Statement query;
            ResultSet answer;
            String sql = "SELECT * FROM `units` WHERE world='"+worldName.toString()+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                while (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        units.add(new Unit(answer.getString("unitId"),
                                           answer.getString("playerId"),
                                           new BlockPosition(answer.getInt("x"),answer.getInt("y")),
                                           WorldName.valueOf(answer.getString("world")),
                                           Orientation.DOWN
                                ));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return units;
        }
    }

    public Unit getUnit(String id) throws ServerException {
        synchronized(lock){
            Unit unit = null;
            Statement query;
            ResultSet answer;
            String sql = "SELECT * FROM `units` WHERE unitId='"+id+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                if (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        unit = new Unit(answer.getString("unitId"),
                                answer.getString("playerId"),
                                new BlockPosition(answer.getInt("x"), answer.getInt("y")),
                                WorldName.valueOf(answer.getString("world")),
                                Orientation.DOWN);
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return unit;
        }
    }

    public ArrayList<Unit> getAllUnits() throws ServerException {
        synchronized(lock){
            ArrayList<Unit> units = new ArrayList();
            Statement query;
            ResultSet answer;
            String sql = "SELECT * FROM `units` WHERE 1;";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    throw new ServerException("no connection to data base");
                }
                answer = query.executeQuery(sql);
                while (answer.next()!=false) {
                    if (answer.wasNull() == false) {
                        Unit unit = new Unit(answer.getString("unitId"),
                                answer.getString("playerId"),
                                new BlockPosition(answer.getInt("x"), answer.getInt("y")),
                                WorldName.valueOf(answer.getString("world")),
                                Orientation.DOWN);
                        units.add(unit);
                    }
                }
                answer.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return units;
        }
    }

}