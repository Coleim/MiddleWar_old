/*
 * Middle War Client
 * 
 */

package middlewar.client;

import middlewar.client.view.world.AgentWorldView;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import middlewar.common.*;

import middlewar.xmwp.*;

import middlewar.client.business.*;
import middlewar.client.business.world.*;
import middlewar.client.exception.*;
import middlewar.client.view.*;
import middlewar.client.view.board.AgentBoardView;
import middlewar.client.view.units.AgentUnitsView;
import middlewar.client.view.xmwp.AgentXMWPView;

/**
 * Middle War client side
 * @author higurashi
 */
public class MainApplet extends JApplet implements Runnable{

    // Data
    private Game game;

    // Views
    private AgentWorldView awv;
    private AgentXMWPView axv;
    private AgentBoardView abv;
    private AgentUnitsView auv;

    // Thread
    private boolean running;
    private Thread thread;

    // panels
    private MainPanel mainPanel;
    private LoadPanel loadPanel;
    private ChatPanel chatPanel;
    private UnitsPanel unitsPanel;
    private ErrorsPanel errorsPanel;

    @Override
    public void init() {
        try {
            initComponents();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Init applet
     */
    private void initComponents() throws ClientException, Exception {

            // Panels
            errorsPanel= new ErrorsPanel();
            mainPanel = new MainPanel(this);
            loadPanel = new LoadPanel(this);
            chatPanel = new ChatPanel(this);

            // Containers
            Container cp = getContentPane();
            JPanel vpanel = new JPanel();
            cp.add(vpanel);

            // Assign layouts
            BoxLayout cpLayout = new BoxLayout(cp,BoxLayout.X_AXIS);
            BoxLayout vpanelLayout = new BoxLayout(vpanel,BoxLayout.Y_AXIS);
            vpanel. setLayout(vpanelLayout);
            cp.setLayout(cpLayout);

            vpanel.add(errorsPanel);

            try{
                game = new Game(getParameter("key"),MiddlewarConfiguration.getXMWPSrvUrl(),this);
                game.start();
                vpanel.add(loadPanel);
                mainPanel.setVisible(false);
                loadPanel.load();
            }
            catch (GameAlreadyStartedException e) {
                // game have alredy started (page reload)    
            }
            catch (Exception e) {
                errorsPanel.addError(e);
            }

            if(awv==null || axv==null || abv==null || auv==null){
                awv = new AgentWorldView(Game.getAgentWorld());
                axv = new AgentXMWPView(AgentXMWPView.ViewLevel.all,Game.getAgentXMWP());
                abv = new AgentBoardView(Game.getAgentBoard());
                auv = new AgentUnitsView(Game.getAgentUnits());
            }
            
            vpanel.add(mainPanel);
            vpanel.add(chatPanel);

    }

    @Override
    public void start() {
        if(!running){
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void destroy() {

        System.out.println("Shutting down MW client ...");
        try {
            try {
                Game.getAgentXMWP().sayByeToServer();
            } catch (ClientException ex) {
                
            }
        } catch (XMWPException e) {

        }

        if(running){
            // stop main thread
            try {
                running = false;
                thread.join(15000);
            } catch (InterruptedException e) {
                System.err.print(e.getMessage());
            }
        }

        System.out.println("MW client exited");

        System.exit(0);
    }

    public AgentXMWPView getAgentXMWPView() {
        return axv;
    }

    public AgentBoardView getAgentBoardView() {
        return abv;
    }

    public AgentWorldView getAgentWorldView() {
        return awv;
    }

    public AgentUnitsView getAgentUnitsView() {
        return auv;
    }

    public ChatPanel getChatPanel(){
        return chatPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }


    @Override
    public void stop() {
        // pause (reduce nav.)
    }

    @Override
    public void run() {
        try {
            running = true;

            Game.getAgentXMWP().sayHelloToServer();

            while (running) {

                Game.getAgentXMWP().sayRefreshMeToServer();
                repaint();
                
                try {
                    Thread.sleep(250);
                } catch (Exception e) {
                    this.errorsPanel.addError(e);
                }
            }

            this.game.stop();

        } catch (XMWPException e) {
            this.game.addError(e.getMessage());
        } catch (ClientException e) {
            this.game.addError(e.getMessage());
        } catch (Exception e) {
            this.addError(e);
        }

        repaint();

    }

    public void addError(Exception e){
        errorsPanel.addError(e);
    }

    public static void main(String[] args){
        // not used
    }

}
