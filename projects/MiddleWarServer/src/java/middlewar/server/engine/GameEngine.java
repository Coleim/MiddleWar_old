/*
 * Middle War - Server
 *
 */

package middlewar.server.engine;


import middlewar.common.Orientation;
import middlewar.server.Server;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.xmwp.XMWPException;

/**
 *
 * @author higurashi
 */
public class GameEngine implements Runnable {

    private Thread gameEngineThread;
    private boolean stop = false;

    private int countLoopPlayersDumps = 0;
    public static final int LOOP_PLAYERS_DUMPS = 30;

    public GameEngine() {
        Server.logs.logMainInfo("start GameEngine");
        gameEngineThread = new Thread(this);
        stop = false;
        gameEngineThread.start();
        Server.logs.logInfo("GameEngine started");
    }

    public void GameInit() {
        try {
            Server.unitManager.LoadAllUnits();

        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        GameInit();
        while(!stop){
            //try {
                //try {
                // todo
                //Server.xmwpUpdateManager.addUpdateInMap(new HelloInformElement(), "basic1");
                //} catch (XMWPException e) {
                //    e.printStackTrace();
                //}
                /*
                try {
                countLoopPlayersDumps++;
                if(countLoopPlayersDumps==LOOP_PLAYERS_DUMPS){
                countLoopPlayersDumps = 0;
                Server.playerManager.savePlayers();
                }
                } catch (ServerException ex) {
                Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
                 */
                //Server.unitManager.moveUnit(Server.unitManager.getUnit("testunit3"), Orientation.RIGHT);
            //} catch (ServerException e) {
            //    e.printStackTrace();
            //} catch (XMWPException e) {
            //    e.printStackTrace();
            //} catch (WorldMakerException e) {
            //    e.printStackTrace();
            //}
             try { Thread.sleep(5000); } catch (Exception e) {}

        }
    }

}
