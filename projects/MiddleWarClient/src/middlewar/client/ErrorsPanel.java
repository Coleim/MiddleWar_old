/*
 * Middle War Client
 *
 */

package middlewar.client;

import java.awt.*;
import javax.swing.*;

/**
 * Display errors (for debug)
 * @author higurashi
 */
public class ErrorsPanel extends JPanel{

    public ErrorsPanel(){
        this.setBackground(Color.red);
        this.setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Add an error message
     * @param error the message
     */
    public void addError(String error){
        this.add(new JTextArea(error));
        this.setVisible(true);
    }

    /**
     * Add an error from an exception
     * @param e the source exception
     */
    public void addError(Exception e){
        String s = new String(e.toString()+"\n");
         StackTraceElement[] elts = e.getStackTrace();

        for( StackTraceElement elt : elts){
            s = s + "\n" + elt.toString();
        }
        this.add(new JTextArea(s));
        this.setVisible(true);
    }

}