package middlewar.client;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import middlewar.client.business.*;
import middlewar.client.exception.ClientException;
import middlewar.common.*;


public class LoadPanel extends JPanel implements Runnable{

    private MainApplet master;
    private JProgressBar bar;
    private Thread thread;

    private ErrorsPanel errorsPanel;

    public LoadPanel( MainApplet master){
        this.setBackground(Color.BLUE);
        this.master = master;
        this.setPreferredSize(new Dimension(AgentWorld.X*Constants.blockPxSize, AgentWorld.Y*Constants.blockPxSize));
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

    @Override
    public void run() {
        this.setVisible(true);
        try {
            Game.preloadImages(bar);
            Thread.sleep(2000);
            this.setVisible(false);
            master.getMainPanel().setVisible(true);
        }
        catch (Exception e) {
            errorsPanel.addError(e);
        }

    }

}
