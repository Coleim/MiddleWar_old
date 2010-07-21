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
import middlewar.client.view.xmwp.AgentXMWPView;
import middlewar.common.*;

public class UnitsPanel extends JPanel{

        private MainApplet master;
        public UnitsPanel(MainApplet master){
            this.master = master;
            this.setPreferredSize(new Dimension(100,AgentWorld.Y*Constants.blockPxSize));
            this.setBackground(Color.red);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

    }