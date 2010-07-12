/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import middlewar.client.business.board.*;
import middlewar.client.business.units.Unit;
import middlewar.client.exception.ClientException;

/**
 * Board game agent
 * @author higurashi
 */
public class AgentBoard extends AbstractAgent{

    private Board board;

    public AgentBoard() throws ClientException {
        this.board = new Board();
    }

    void setBlockCursor(int x, int y) {
        this.board.setBlockCursorPosition(x,y);
    }

    void setBlockCursor(int x, int y, boolean b) {
        this.board.setBlockCursorPosition(x,y);
        this.board.setBlockCursorVisible(true);
    }

    void setBlockCursor(int x, int y, boolean b,String image) throws ClientException {
        this.board.setBlockCursorPosition(x,y);
        this.board.setBlockCursorVisible(true);
        this.board.setBlockCursorImage(image);
    }

    void setBlockCursorVisible(boolean b) {
        this.board.setBlockCursorVisible(b);
    }

    @Override
    public void notifyUnit(Unit u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
