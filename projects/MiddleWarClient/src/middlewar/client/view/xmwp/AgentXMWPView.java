/*
 * Middle War Client
 *
 */

package middlewar.client.view.xmwp;

import middlewar.client.view.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Date;
import middlewar.client.business.*;
import middlewar.common.*;
import middlewar.client.business.xmwp.*;
import middlewar.client.exception.ClientException;


/**
 * View of AgentXMWP
 * @author higurashi
 */
public class AgentXMWPView extends View {

    private ViewLevel level;
    private AgentXMWP agent;

    /**
     * Constructor
     * @param level the view level
     * @param agent the agent to display
     */
    public AgentXMWPView(ViewLevel level,AgentXMWP agent) {
        this.level = level;
        this.agent = agent;
    }

    /**
     * Constructor
     * @param agent the agent to display
     */
    public AgentXMWPView(AgentXMWP link) {
        this.level = ViewLevel.all;
        this.agent = link;
    }

    /** Display level */
    public enum ViewLevel{
        all,
        only_send,
        only_recv
    }

    @Override
    public void paint(Graphics g,ImageObserver io,Position position) throws ClientException{
        String[] recvInformHistory = this.agent.getRecvInformHistory();
        String[] recvRequestHistory = this.agent.getRecvRequestHistory();
        String[] sendInformHistory = this.agent.getSendInformHistory();
        String[] sendRequestHistory = this.agent.getSendRequestHistory();
        Date[] getSendDateHistory = this.agent.getSendDateHistory();
        int dec = 10;
        
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 9));

        if(this.level == ViewLevel.all || this.level == ViewLevel.only_recv){
            int j = 0;
            for(int i=0;i<XMWPClientThread.historySize;i++){
               j = j + 1;
               if(sendInformHistory[i]==null) sendInformHistory[i]="#";
               if(recvInformHistory[i]==null) recvInformHistory[i]="#";
               if(sendRequestHistory[i]==null) sendRequestHistory[i]="#";
               if(recvRequestHistory[i]==null) recvRequestHistory[i]="#";
               int a = sendInformHistory[i].length();
               int b = recvInformHistory[i].length();
               int c = sendRequestHistory[i].length();
               int d = recvRequestHistory[i].length();
               g.setColor(Color.GRAY);
               g.drawString("send: ",position.getPxX(),j*dec+10 + position.getPxY());
               g.drawString(" / recv:",position.getPxX()+60+a*5+c*5,j*dec+10 + position.getPxY());
               if(getSendDateHistory[i]!=null) g.drawString(" / "+getSendDateHistory[i].getTime(),position.getPxX()+135+b*5+a*5+c*5+d*5,j*dec+10 + position.getPxY());
               g.setColor(Color.GREEN);
               if(sendInformHistory[i]!=null) g.drawString("INF"+sendInformHistory[i],position.getPxX()+30,j*dec+10 + position.getPxY());
               if(recvInformHistory[i]!=null) g.drawString("INF"+recvInformHistory[i],position.getPxX()+105+a*5+c*5,j*dec+10 + position.getPxY());
               g.setColor(Color.BLUE);
               if(sendRequestHistory[i]!=null) g.drawString(" REQ"+sendRequestHistory[i],position.getPxX()+40+a*5,j*dec+10 + position.getPxY());
               if(recvRequestHistory[i]!=null) g.drawString(" REQ"+recvRequestHistory[i],position.getPxX()+115+b*5+a*5+c*5,j*dec+10 + position.getPxY());
               
            }

        }

    }

}

