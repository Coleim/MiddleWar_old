/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import middlewar.common.Position;
import middlewar.client.business.xmwp.*;
import middlewar.client.exception.ClientException;


/**
 * Server messages view
 * @author higurashi
 */
public class CommunicatorView extends View {

    private ViewLevel level;
    private XMWPClientThread link;

    public CommunicatorView(ViewLevel level,XMWPClientThread link) {
        this.level = level;
        this.link = link;
    }

    public CommunicatorView(XMWPClientThread link) {
        this.level = ViewLevel.all;
        this.link = link;
    }


    public void paint(Graphics g,ImageObserver io,Position position) throws ClientException{
        String[] recvInformHistory = this.link.getRecvInformHistory();
        String[] recvRequestHistory = this.link.getRecvRequestHistory();
        String[] sendInformHistory = this.link.getSendInformHistory();
        String[] sendRequestHistory = this.link.getSendRequestHistory();
        int dec = 10;
        
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 9));

        if(this.level == ViewLevel.all || this.level == ViewLevel.only_recv){
            int j = 0;
            for(int i=0;i<XMWPClientThread.historySize;i++){
               j = j + 2;
               g.setColor(Color.GREEN);
               if(sendInformHistory[i]!=null) g.drawString("send:"+sendInformHistory[i],position.getPxX(),j*dec+10 + position.getPxY());
               if(recvInformHistory[i]!=null) g.drawString("recv:"+recvInformHistory[i],position.getPxX(),(j+1)*dec+10 + position.getPxY());
               g.setColor(Color.BLUE);
               int a = 0;
               if(sendInformHistory[i]!=null) a = sendInformHistory[i].length();
               int b = 0;
               if(recvInformHistory[i]!=null) a = sendInformHistory[i].length();
               g.drawString(" "+sendRequestHistory[i],position.getPxX()+10+a*6,j*dec+10 + position.getPxY());
               g.drawString(" "+recvRequestHistory[i],position.getPxX()+10+b*6,(j+1)*dec+10 + position.getPxY());
            }

        }

    }

    /**
     * debug level
     */
    public enum ViewLevel{
        all,
        only_send,
        only_recv
    }

}

