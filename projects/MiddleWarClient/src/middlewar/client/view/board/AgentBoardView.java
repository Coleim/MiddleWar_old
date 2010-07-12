/*
 * Middle War - Client
 *
 */

package middlewar.client.view.board;

import middlewar.client.view.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import middlewar.common.BlockPosition;
import middlewar.common.Constains;
import middlewar.common.Position;
import middlewar.client.exception.*;
import middlewar.client.business.board.*;


/**
 * board view
 * @author higurashi
 */
public class AgentBoardView extends View {

    private Board board;


    public AgentBoardView(Board board) {
        this.board = board;
    }

    public void paintFront(Graphics g,ImageObserver io,Position position) throws ClientException{

        for(BlockPosition p : this.board.getIcons().keySet()){
            g.drawImage(this.board.getIcons().get(p), p.getBlockX(), p.getBlockY(), io);
        }

        if(this.board.getCursorImage()!=null){
            //int h = this.board.getBlockCursorImage().getHeight(null);
            //int w = this.board.getBlockCursorImage().getWidth(null);
            g.drawImage(this.board.getCursorImage(),
                        this.board.getCursorPosition().getPxX(),
                        this.board.getCursorPosition().getPxY(),
                        io);
        }

    }

    public void paintBack(Graphics g,ImageObserver io,Position position) throws ClientException{

        if(this.board.getBlockCursorImage()!=null && this.board.isBlockCursorVisible()){
            int h = this.board.getBlockCursorImage().getHeight(null);
            int w = this.board.getBlockCursorImage().getWidth(null);

            g.drawImage(this.board.getBlockCursorImage(),
                        this.board.getBlockCursorPosition().getPxX()-(w/2)+(Constains.blockPxSize/2),
                        this.board.getBlockCursorPosition().getPxY()-(h/2)+(Constains.blockPxSize/2),
                        io);
        }

    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        paintBack(g,io,position);
        paintFront(g,io,position);
    }

}

