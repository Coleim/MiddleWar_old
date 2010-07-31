/*
 * Middle War - Server
 *
 */

package middlewar.server.data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import middlewar.common.*;
import middlewar.server.managers.IDataManager;
import middlewar.server.Server;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.WorldName;

/**
 * Acces à la base de donnée (access layer)
 * base de donnée MySQL: 5.0
 * @author higurashi
 */
public class DataManager implements IDataManager{

    private final Object lock;

    private com.mysql.jdbc.Connection link;
    private String myURL = "jdbc:mysql://195.13.32.118/mw";
    private String myLogin = "mwextuser";//"mwuser"
    private String myPwd = "cRwFPhPcMBeKwzah";//"cRwFPhPcMBeKwzah"

    /**
     * Initialise the manager
     */
    public DataManager(){
        Server.logs.logMainInfo("start DataManager");
        lock = new Object();
        initConnection();
        Server.logs.logInfo("DataManager started");
    }

    private void initConnection(){
        synchronized(lock){
            try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    link = (Connection) DriverManager.getConnection(myURL,myLogin,myPwd);
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
        }
    }

    @Override
    public DAOPlayer getPlayer(String id) throws ServerException{
        initConnection();
        synchronized(lock){
            DAOPlayer player = null;
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
                        player = new DAOPlayer(answer.getString("playerId"),this.getPlayerUnitsIds(id));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
            if(player==null) throw new ServerException("no player with id '"+id+"'");
            return player;
        }
    }

    @Override
    public boolean verifyPlayerPassword(String id,String password) throws ServerException{
        initConnection();
        synchronized(lock){
            boolean result = false;
            Statement query;
            ResultSet answer;
            String sql = "SELECT count(*) FROM `players` WHERE playerId='"+id+"' AND playerPassword='"+password+"';";
            try {
                try{
                    query = this.link.createStatement();
                }catch (NullPointerException e) {
                    System.out.println(sql);
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
                Server.logs.logError(e);
            }
            return result;
        }
    }

    @Override
    public ArrayList<DAOUnit> getPlayerUnits(String id) throws ServerException{
        initConnection();
        synchronized(lock){
            ArrayList<DAOUnit> units = new ArrayList<DAOUnit>();
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
                        units.add(new DAOUnit(answer.getString("unitId"),
                                           id,
                                           new BlockPosition(answer.getInt("x"),answer.getInt("y")),
                                           WorldName.valueOf(answer.getString("world")),
                                           Orientation.DOWN
                                ));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
            return units;
        }
    }

    @Override
    public ArrayList<String> getPlayerUnitsIds(String id) throws ServerException{
        initConnection();
        synchronized(lock){
            ArrayList<String> units = new ArrayList<String>();
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
                Server.logs.logError(e);
            }
            return units;
        }
    }

    @Override
    public ArrayList<DAOUnit> getWorldUnits(WorldName worldName) throws ServerException {
        initConnection();
        synchronized(lock){
            ArrayList<DAOUnit> units = new ArrayList<DAOUnit>();
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
                        units.add(new DAOUnit(answer.getString("unitId"),
                                           answer.getString("playerId"),
                                           new BlockPosition(answer.getInt("x"),answer.getInt("y")),
                                           WorldName.valueOf(answer.getString("world")),
                                           Orientation.DOWN
                                ));
                    }
                }
                answer.close();
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
            return units;
        }
    }
    
    @Override
    public DAOUnit getUnit(String id) throws ServerException {
        initConnection();
        synchronized(lock){
            DAOUnit unit = null;
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
                        unit = new DAOUnit(answer.getString("unitId"),
                                answer.getString("playerId"),
                                new BlockPosition(answer.getInt("x"), answer.getInt("y")),
                                WorldName.valueOf(answer.getString("world")),
                                Orientation.DOWN);
                    }
                }
                answer.close();
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
            return unit;
        }
    }
    @Override
    public ArrayList<DAOUnit> getAllUnits() throws ServerException {
        initConnection();
        synchronized(lock){
            ArrayList<DAOUnit> units = new ArrayList();
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
                        DAOUnit unit = new DAOUnit(answer.getString("unitId"),
                                answer.getString("playerId"),
                                new BlockPosition(answer.getInt("x"), answer.getInt("y")),
                                WorldName.valueOf(answer.getString("world")),
                                Orientation.DOWN);
                        units.add(unit);
                    }
                }
                answer.close();
            } catch (SQLException e) {
                Server.logs.logError(e);
            }
            return units;
        }
    }
    @Override
    public void savePlayer(DAOPlayer p) {
        // todo
    }
    @Override
    public void saveUnits(ArrayList<DAOUnit> units) {
        // todo
    }


}