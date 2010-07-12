/*
 * Middle War Client
 *
 */

package middlewar.client.view.board;

import middlewar.client.view.*;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import middlewar.client.business.AgentBoard;
import middlewar.client.business.AgentWorld;
import middlewar.common.BlockPosition;
import middlewar.common.Constains;
import middlewar.common.Position;
import middlewar.client.exception.*;


/**
 * View of AgentBoard
 * @author higurashi
 */
public class AgentBoardView extends View {

    private AgentBoard agent;

    /**
     * Constructor
     * @param agent the agent to display
     */
    public AgentBoardView(AgentBoard agent) {
        this.agent = agent;
    }

    public void paintFront(Graphics g,ImageObserver io,Position position) throws ClientException{

        for(BlockPosition p : this.agent.getIcons().keySet()){
            g.drawImage(this.agent.getIcons().get(p), p.getBlockX(), p.getBlockY(), io);
        }

        if(this.agent.getCursorImage()!=null){
            //int h = this.board.getBlockCursorImage().getHeight(null);
            //int w = this.board.getBlockCursorImage().getWidth(null);
            g.drawImage(this.agent.getCursorImage(),
                        this.agent.getCursorPosition().getPxX(),
                        this.agent.getCursorPosition().getPxY(),
                        io);
        }

        g.drawString(this.agent.getCursorPosition().toString(), this.agent.getCursorPosition().getPxX(), this.agent.getCursorPosition().getPxY());

    }

    public void paintBack(Graphics g,ImageObserver io,Position position) throws ClientException{

        if(this.agent.getBlockCursorImage()!=null && this.agent.isBlockCursorVisible()){
            int h = this.agent.getBlockCursorImage().getHeight(null);
            int w = this.agent.getBlockCursorImage().getWidth(null);

            g.drawImage(this.agent.getBlockCursorImage(),
                        this.agent.getBlockCursorPosition().getPxX()-(w/2)+(Constains.blockPxSize/2),
                        this.agent.getBlockCursorPosition().getPxY()-(h/2)+(Constains.blockPxSize/2),
                        io);
        }

    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        paintBack(g,io,position);
        paintFront(g,io,position);
    }

}

