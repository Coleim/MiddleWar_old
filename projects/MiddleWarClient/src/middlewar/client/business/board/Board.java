/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.client.business.board;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import middlewar.client.business.Game;
import middlewar.common.BlockPosition;
import middlewar.common.Position;
import middlewar.common.PxPosition;
import middlewar.client.exception.ClientException;
import middlewar.client.exception.DataException;

/**
 *
 * @author jonathan
 */
public class Board {

    private Image cursorHandImage = null;
    private Image cursorUpImage = null;
    private Image cursorDownImage = null;
    private Image cursorRightImage = null;
    private Image cursorLeftImage = null;

    private Image cursorImage = null;
    private PxPosition cursorPosition = new PxPosition(0, 0);

    private Hashtable<BlockPosition,Image> icons;

    private BlockPosition blockCursorPosition = new BlockPosition(0, 0);
    private Image blockCursorImage = null;
    private boolean blockCursorVisible = false;

    public Board() throws ClientException {
        icons = new Hashtable<BlockPosition, Image>();
        try {
            cursorHandImage = Game.getImage(new URL(Game.DATA_URL_SCREEN + "hand.png"));
            cursorUpImage = Game.getImage(new URL(Game.DATA_URL_SCREEN + "up.png"));
            cursorDownImage = Game.getImage(new URL(Game.DATA_URL_SCREEN + "down.png"));
            cursorRightImage = Game.getImage(new URL(Game.DATA_URL_SCREEN + "right.png"));
            cursorLeftImage = Game.getImage(new URL(Game.DATA_URL_SCREEN + "left.png"));
        } catch (MalformedURLException e) {
            throw new DataException(e.getMessage());
        }
    }

    public void setCursor(Cursor cursor){
        switch(cursor){
            case HAND : this.cursorImage = cursorHandImage; break;
            case UP : this.cursorImage = cursorUpImage; break;
            case DOWN : this.cursorImage = cursorDownImage; break;
            case LEFT : this.cursorImage = cursorLeftImage; break;
            case RIGHT : this.cursorImage = cursorRightImage; break;
        }
    }

    public Image getCursorImage() {
        return cursorImage;
    }

    public PxPosition getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(PxPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public void setCursorPosition(int x, int y) {
        this.cursorPosition.setPxX(x);
        this.cursorPosition.setPxY(y);
    }

    public enum Cursor{
        HAND,
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public Hashtable<BlockPosition,Image> getIcons(){
        return icons;
    }

    public boolean isBlockCursorVisible() {
        return this.blockCursorVisible;
    }

    public void setBlockCursorImage(String cursor) throws ClientException{
        try {
            URL url = new URL(Game.DATA_URL_SCREEN + cursor);
            blockCursorImage = Game.getImage(url);

        } catch (MalformedURLException e) {
            throw new DataException(e.getMessage());
        }
    }

    public Image getBlockCursorImage(){
        return this.blockCursorImage;
    }

    public void setBlockCursorPosition(BlockPosition position){
        this.blockCursorPosition = position;
    }

    public BlockPosition getBlockCursorPosition(){
        return this.blockCursorPosition;
    }

    public void setBlockCursorPosition(int x, int y) {
        this.blockCursorPosition.setBlockX(x);
        this.blockCursorPosition.setBlockY(y);
    }

    public void setBlockCursorVisible(boolean visible) {
        this.blockCursorVisible = visible;
    }


}
