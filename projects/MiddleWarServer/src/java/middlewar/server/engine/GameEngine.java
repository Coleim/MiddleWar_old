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
public class GameEngine implements Runnable{

    private Thread gameEngineThread;
    private boolean stop = false;

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
            try {
                // todo
                Server.xmwpUpdateManager.addUpdateInMap(new HelloInformElement(), "basic1");
            } catch (XMWPException e) {
                e.printStackTrace();
            }


             try { Thread.sleep(1000); } catch (Exception e) {}

        }
    }

}
