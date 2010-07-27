/*
 * Middle War Client
 *
 */

package middlewar.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import middlewar.client.business.*;
import middlewar.client.exception.ClientException;
import middlewar.client.exception.DataException;
import middlewar.common.*;

public class MainPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener{

    private MainApplet master;

    public MainPanel(MainApplet main){
        this.master = main;

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(AgentWorld.X*Constants.blockPxSize, AgentWorld.Y*Constants.blockPxSize));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // World (back)
        try{
            master.getAgentWorldView().paintBack(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        // Board (back)
        try{
            master.getAgentBoardView().paintBack(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        // Unit
        try{
            master.getAgentUnitsView().paint(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        // World (front)
        try{
            master.getAgentWorldView().paintFront(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        // Board (front)
        try{
            master.getAgentBoardView().paintFront(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        // XMWP
        try{
            master.getAgentXMWPView().paint(g, this, PxPosition.origin);
        }
        catch(DataException e){ Game.getInstance().addError(e.getMessage()); }
        catch(ClientException e){ Game.getInstance().addError(e.getMessage()); }
        catch(Exception e){ master.addError(e); }

        int i = 1;
        for (String err : Game.getInstance().getErrors()) {
            g.setColor(Color.RED);
            g.drawString(err, 0, 15+i*10);
            i = i + 1;
        }
        for (String info : Game.getInstance().getInfos()) {
            g.setColor(Color.YELLOW);
            g.drawString(info, 0, 300+15+i*10);
            i = i + 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try{
            Game.getInstance().mouseClicked(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try{
            Game.getInstance().mouseEntered(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try{
            Game.getInstance().mouseExited(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        try{
            Game.getInstance().mouseMoved(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try{
            Game.getInstance().keyTyped(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            Game.getInstance().keyPressed(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try{
            Game.getInstance().keyReleased(e);
        }catch(ClientException ex){
            Game.getInstance().addError(ex.getMessage());
        }
        master.repaint();
    }

}