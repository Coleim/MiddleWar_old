/*
 * Middle War - Server
 *
 */

package middlewar.server.engine;

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

    public void run() {
        while(!stop){


            // todo



             try { Thread.sleep(1000); } catch (Exception e) {}

        }
    }

}
