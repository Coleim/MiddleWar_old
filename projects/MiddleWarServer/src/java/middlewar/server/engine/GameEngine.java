/*
 * Middle War - Server
 *
 */

package middlewar.server.engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.server.Server;
import middlewar.server.exception.ServerException;
import middlewar.xmwp.XMWPException;
import middlewar.xmwp.elements.inform.HelloInformElement;

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
        gameEngineThread = new Thread(this);
        stop = false;
        gameEngineThread.start();
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
             try { Thread.sleep(1000); } catch (Exception e) {}

        }
    }

}
