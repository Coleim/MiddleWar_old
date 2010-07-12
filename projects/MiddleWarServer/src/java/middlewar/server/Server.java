/*
 * Middle War - Server
 *
 */

package middlewar.server;

import middlewar.server.business.player.PlayerManager;
import middlewar.server.business.unit.UnitManager;
import middlewar.server.engine.GameEngine;

/**
 * Access to all managers
 * @author higurashi
 */
public class Server {

    public static final String logFile = "./serverlog.txt";

    public static final DataManager dataManager = new DataManager();
    public static final PlayerManager playerManager = new PlayerManager();
    public static final UnitManager unitManager = new UnitManager();

    public static final GameEngine gameEngine = new GameEngine();
    
}
