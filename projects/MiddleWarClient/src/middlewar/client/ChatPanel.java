/*
 * Middle War Client
 *
 */

package middlewar.client;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import middlewar.client.business.*;
import middlewar.client.business.units.UnitSpeak;
import middlewar.client.exception.ClientException;
import middlewar.common.*;

/**
 * The chat pannel allow to send messages, and see
 * hisory of messages.
 * @author higurashi
 */
public class ChatPanel extends JPanel{

    private JTextPane textPane;
    private JScrollPane scrollPane;
    private JTextField textField;
    private JButton sendButton;

    private final MainApplet master;

    public ChatPanel(MainApplet master) {

        this.master = master;

        this.textPane = new JTextPane();
        this.textField = new JTextField();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.sendButton = new JButton("Talk!");
        this.textPane.setPreferredSize(new Dimension(AgentWorld.X*Constants.blockPxSize,60));
        Font font = new Font("Serif", Font.PLAIN, 10);
        this.textPane.setFont(font);
        this.scrollPane = new JScrollPane(this.textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel,BoxLayout.X_AXIS ));
        subpanel.add(this.textField);
        subpanel.add(this.sendButton);
        subpanel.setPreferredSize(new Dimension(AgentWorld.X*Constants.blockPxSize, 20));

        this.add(this.scrollPane);
        this.add(subpanel);

        sendButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Game.getInstance().onChatSendMessageClicked(ChatPanel.this.textField.getText());
                } catch (ClientException ex) {
                    ChatPanel.this.master.addError(ex);
                }
                ChatPanel.this.textField.setText("");
                ChatPanel.this.scrollPane.getVerticalScrollBar().setValue(0);
            }

        });

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        Game.getInstance().onChatSendMessageClicked(ChatPanel.this.textField.getText());
                    } catch (ClientException ex) {
                        ChatPanel.this.master.addError(ex);
                    }
                    ChatPanel.this.textField.setText("");
                    ChatPanel.this.scrollPane.getVerticalScrollBar().setValue(0);
                }
            }

        });


    }

    public void updateChat() {
        this.textPane.setText("");
        Iterable<String> itr = Game.getInstance().getChatUnitSpeaks();
        for(String str : itr){
            this.textPane.setText(str+"\n"+this.textPane.getText());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}