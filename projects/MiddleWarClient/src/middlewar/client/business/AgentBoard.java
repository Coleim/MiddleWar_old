/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import middlewar.client.business.board.*;
import middlewar.client.business.units.*;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;
import middlewar.common.PxPosition;

/**
 * Board game agent
 * @author higurashi
 */
public class AgentBoard extends AbstractAgent{

    private Board board; // business object
    
    /*
     * Agent management methods
     */

    private static AgentBoard instance = null;

    public static AgentBoard getInstance() throws ClientException{
        if(instance == null) throw new ClientException("AgentBoard not initialized (call init())");
        return instance;
    }

    public static void init() throws ClientException {
        instance = new AgentBoard();
    }

    private AgentBoard() throws ClientException {
        this.board = new Board();
    }

    /*
     * AbstractAgent methods implementation
     */

    @Override
    public void mouseExited(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        board.setBlockCursorVisible(false);
    }

    @Override
    public void mouseMoved(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {

        //if(Game.getAgentWorld().isBlockInWorld(mapPosition)){

            if(Game.getAgentUnits().getUnit(mapPosition) != null){
                this.setBlockCursor(x, y, true, "cursor_circle.png");
            }
            else{
                this.setBlockCursor(x, y, true, "cursor_case.png");
                /*
                if(Game.getAgentWorld().isBlockPassing(mapPosition)){
                    this.setBlockCursor(x, y, true, "cursor_case.png");
                }else{
                    this.setBlockCursor(x, y, true, "cursor_case.png");
                }
                */
                
            }

            if(Game.getAgentUnits().getSelectedUnit()!=null){
                BlockPosition selected = Game.getAgentUnits().getSelectedUnit().getPosition();

                //TODO: Only display arrows where the player could go.

                if(selected.up().equals(mapPosition)) {
                    this.setBlockCursor(x, y, true, "up.png");
                } else if(selected.down().equals(mapPosition)) {
                    this.setBlockCursor(x, y, true, "down.png");
                } else if(selected.right().equals(mapPosition)) {
                    this.setBlockCursor(x, y, true, "right.png");
                } else if(selected.left().equals(mapPosition)) {
                    this.setBlockCursor(x, y, true, "left.png");
                }
            }

        //}else board.setBlockCursorVisible(false);
    }

    /*
     * Business methods
     */

    public Hashtable<BlockPosition,Image> getIcons(){
        return board.getIcons();
    }

    public Image getCursorImage() {
        return board.getCursorImage();
    }

    public PxPosition getCursorPosition() {
        return board.getCursorPosition();
    }

    public BlockPosition getBlockCursorPosition(){
        return board.getBlockCursorPosition();
    }

    public boolean isBlockCursorVisible() {
        return board.isBlockCursorVisible();
    }

    public Image getBlockCursorImage(){
        return board.getBlockCursorImage();
    }

    private void setBlockCursor(int x, int y, boolean b) {
        this.board.setBlockCursorPosition(x,y);
        this.board.setBlockCursorVisible(true);
    }

    private void setBlockCursor(int x, int y, boolean b,String image) throws ClientException {
        this.board.setBlockCursorPosition(x,y);
        this.board.setBlockCursorVisible(true);
        this.board.setBlockCursorImage(image);
    }


}
