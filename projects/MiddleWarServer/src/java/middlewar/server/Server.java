/*
 * Middle War - Server
 *
 */

package middlewar.server;

import middlewar.server.managers.IDataManager;
import middlewar.server.managers.IWorldManager;
import middlewar.server.managers.IUnitManager;
import middlewar.server.managers.IXMWPUpdateManager;
import middlewar.server.managers.IPlayerManager;
import middlewar.server.business.aimanager.AIEngine;
import middlewar.server.business.player.PlayerManager;
import middlewar.server.business.unit.UnitManager;
import middlewar.server.business.world.WorldManager;
import middlewar.server.data.DataManager;
import middlewar.server.engine.GameEngine;
import middlewar.server.xmwp.XMWPUpdateManager;

/**
 * Main server class
 * @author higurashi
 */
public class Server {

    // logs
    public static final MiddleWarLogger logs = new MiddleWarLogger();

    // Game managers
    public static final IDataManager dataManager = new DataManager();
    public static final IPlayerManager playerManager = new PlayerManager();
    public static final IUnitManager unitManager = new UnitManager();
    public static final IWorldManager worldManager = new WorldManager();
    public static final IXMWPUpdateManager xmwpUpdateManager = new XMWPUpdateManager();

    // Engines
    public static final GameEngine gameEngine = new GameEngine();
    public static final AIEngine aiEngine = new AIEngine();
    
}
