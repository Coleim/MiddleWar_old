/*
 * Middle War - Client
 * 
 */

package middlewar.client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import middlewar.common.*;

import middlewar.xmwp.*;

import middlewar.client.business.*;
import middlewar.client.business.world.*;
import middlewar.client.exception.*;
import middlewar.client.view.*;

/**
 * Middle War client side
 * @author higurashi
 */
public class MainApplet extends JApplet implements Runnable{

    // Data
    private Game game;

    // Views
    //private WorldAgentView wv;
    private CommunicatorView slv;
    //private BoardView tbv;
    //private UnitsBoardView ubv;

    // Thread
    private boolean running;
    private Thread thread;

    // panels
    private MainPanel mainPanel;
    private LoadPanel loadPanel;
    private ChatPanel chatPanel;
    private UnitsPanel unitsPanel;

    @Override
    public void init() {
        initComponents();
    }

    /**
     * Init applet
     */
    private void initComponents() {

        try{

            mainPanel = new MainPanel(this);
            loadPanel = new LoadPanel(this);
            chatPanel = new ChatPanel(this);
            unitsPanel = new UnitsPanel(this);

            game = new Game(getParameter("key"),MiddlewarConfiguration.getXMWPSrvUrl(),mainPanel,chatPanel);

            game.start();

            //wv = new WorldAgentView(game.getAgentWorld());
            slv = new CommunicatorView(CommunicatorView.ViewLevel.all,
                    game.getAgentCommunication().getCommunicator());
            //tbv = new BoardView(game.getAgentBoard().getBoard());
            //ubv = new UnitsBoardView(game.getAgentUnit().getUnitsBoard());
            
            Container cp = getContentPane();

            BoxLayout layout = new BoxLayout(cp,BoxLayout.X_AXIS);
            JPanel subpanel1 = new JPanel();
            BoxLayout layout1 = new BoxLayout(subpanel1,BoxLayout.Y_AXIS);
            subpanel1.setLayout(layout1);

            cp.setLayout(layout);

            //cp.add(loadPanel);

            //loadPanel.load();
            
            //mainPanel.setVisible(false);

            subpanel1.add(mainPanel);
            
            subpanel1.add(chatPanel);
            cp.add(subpanel1);
            //cp.add(unitsPanel);

            //this.addMouseListener(new MainMouseAdapter());
            
         }
         catch (Exception e){
            System.err.print(e.getMessage());
         }
    }

    public class LoadPanel extends JPanel implements Runnable{

        private MainApplet master;
        private JProgressBar bar;

        public LoadPanel(MainApplet master){
            this.master = master;
            this.setBackground(Color.DARK_GRAY);
            
            this.setPreferredSize(new Dimension(AgentWorld.X*Constains.blockPxSize, AgentWorld.Y*Constains.blockPxSize));
            bar = new JProgressBar();
            this.add(bar);
        }

        public void load(){
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

        public void run() {
            try {
                Game.preloadImages(bar);
            } catch (ClientException e) {
                master.game.addError(e.getMessage());
                e.printStackTrace();
            }
            this.setVisible(false);
            master.mainPanel.setVisible(true);
        }

    }

    public class ChatPanel extends JPanel{

        private MainApplet master;
        private JTextPane textPane;
        private JTextField textField;
        private JButton sendButton;

        public ChatPanel(MainApplet master){
            this.master = master;
            this.textPane = new JTextPane();
            this.textField = new JTextField();
            this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            this.sendButton = new JButton("Talk!");
            this.textPane.setPreferredSize(new Dimension(AgentWorld.X*Constains.blockPxSize,60));

            this.textPane.setText("coucou");
            

            JPanel subpanel = new JPanel();
            subpanel.setLayout(new BoxLayout(subpanel,BoxLayout.X_AXIS ));
            subpanel.add(this.textField);
            subpanel.add(this.sendButton);
            subpanel.setPreferredSize(new Dimension(AgentWorld.X*Constains.blockPxSize, 20));
            
            this.add(this.textPane);
            this.add(subpanel);

            sendButton.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    ChatPanel.this.master.game.onChatSendMessageClicked(ChatPanel.this.textField.getText());
                    ChatPanel.this.textField.setText("");
                }

            });

            textField.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER){
                        ChatPanel.this.master.game.onChatSendMessageClicked(ChatPanel.this.textField.getText());
                        ChatPanel.this.textField.setText("");
                    }
                }

            });

            
        }

        public void addChatHistory(String source,String message){
            this.textPane.setText(this.textPane.getText()+"\n"+source+">"+message);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

    }

    public class UnitsPanel extends JPanel{

        private MainApplet master;
        public UnitsPanel(MainApplet master){
            this.master = master;
            this.setPreferredSize(new Dimension(100,AgentWorld.Y*Constains.blockPxSize));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
        
    }

    public class MainPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener{

        private MainApplet master;

        public MainPanel(MainApplet master){
            this.master = master;
            this.setBackground(Color.BLACK);
            this.setPreferredSize(new Dimension(AgentWorld.X*Constains.blockPxSize, AgentWorld.Y*Constains.blockPxSize));
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        @Override
        @SuppressWarnings("empty-statement")
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            try{
                //master.wv.paintBack(g, this, PxPosition.origin);
                //master.tbv.paintBack(g, this, PxPosition.origin);
                //master.ubv.paint(g, this, PxPosition.origin);
                //master.wv.paintFront(g, this, PxPosition.origin);
                //master.tbv.paintFront(g, this, PxPosition.origin);
                master.slv.paint(g, this, PxPosition.origin);
            }
            catch(DataException e){
                master.game.addError(e.getMessage());
            }
            catch(ClientException e){
                master.game.addError(e.getMessage());
            }

            int i = 1;
            for (String err : master.game.getErrors()) {
                g.setColor(Color.RED);
                g.drawString(err, 0, 15+i*10);
                i = i + 1;
            }
            for (String info : master.game.getInfos()) {
                g.setColor(Color.BLACK);
                g.drawString(info, 0, 300+15+i*10);
                i = i + 1;
            }
        }

        public void mouseClicked(MouseEvent e) {
            try{
                master.game.mouseClicked(e);
            }catch(ClientException ex){
                master.game.addError(ex.getMessage());
            }
            master.repaint();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            try{
                master.game.mouseEntered(e);
            }catch(ClientException ex){
                master.game.addError(ex.getMessage());
            }
            master.repaint();
        }

        public void mouseExited(MouseEvent e) {
            try{
                master.game.mouseExited(e);
            }catch(ClientException ex){
                master.game.addError(ex.getMessage());
            }
            master.repaint();
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            try{
                master.game.mouseMoved(e);
            }catch(ClientException ex){
                master.game.addError(ex.getMessage());
            }
            master.repaint();
        }

        public void keyTyped(KeyEvent arg0) {
        }

        public void keyPressed(KeyEvent arg0) {
        }

        public void keyReleased(KeyEvent arg0) {
        }
        
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
            this.game.getAgentCommunication().sayByeToServer();
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

    @Override
    public void stop() {
        // pause (reduce nav.)
    }

    @Override
    public void run() {
        try {
            running = true;

            this.game.getAgentCommunication().sayHelloToServer();
            while (running) {
                this.game.getAgentCommunication().sayRefreshMeToServer();
                repaint();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            
        } catch (XMWPException e) {
            this.game.addError(e.getMessage());
        }

        this.game.stop();

    }

    public static void main(String[] args){
        // not used
    }

}
