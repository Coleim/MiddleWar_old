/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;
import middlewar.client.business.units.Unit;
import middlewar.client.business.world.*;
import middlewar.client.exception.ClientException;
import middlewar.common.*;

/**
 * World game agent
 * @author higurashi
 */
public class AgentWorld extends AbstractAgent{

    public Hashtable<String,Map> maps = new Hashtable<String,Map>();
    
    private BlockPosition focusPosition;
    public static final int X = 13;
    public static final int Y = 13;

    /*
     * Agent management methods
     */

    private static AgentWorld instance = null;

    public static AgentWorld getInstance() throws ClientException{
        if(instance == null) throw new ClientException("AgentWorld not initialized (call init())");
        return instance;
    }

    public static void init() throws ClientException {
        instance = new AgentWorld();
    }

    private AgentWorld() {
        focusPosition = new BlockPosition(5, 5);
    }

    /*
     * AbstractAgent methods implementation
     */

    @Override
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        Unit u = Game.getAgentUnits().getUnit(mapPosition);
        if(u != null){
            if(u.getPlayerId().equals(Game.getInstance().getPlayerId()))
                focusPosition = mapPosition;
        }
    }

    /*
     * Business methods
     */

    public BlockPosition getFocusPosition() {
        return focusPosition;
    }

    public void setFocusPosition(BlockPosition focusPosition) {
        this.focusPosition = focusPosition;
    }

    public boolean isPositionFocused(BlockPosition p){
        boolean focus = false;
        if(focusPosition.getBlockX()-X < p.getBlockX() &&
                focusPosition.getBlockX()+X > p.getBlockX() &&
                focusPosition.getBlockY()-Y < p.getBlockY() &&
                focusPosition.getBlockY()+Y > p.getBlockY() ) focus = true;
        return focus;
    }

    /*
    public boolean isBlockPassing(int x, int y){
        return !( !C.isPassing(x, y, Orientation.UP) &&
                !C.isPassing(x, y, Orientation.DOWN) &&
                !C.isPassing(x, y, Orientation.LEFT) &&
                !C.isPassing(x, y, Orientation.RIGHT));

    }

     */

    public boolean isBlockPassing(BlockPosition mapPosition){
    //    return isBlockPassing(mapPosition.getBlockX(), mapPosition.getBlockY());
    return true;
    }

    public boolean isBlockInWorld(int x,int y) throws ClientException{
        return x >= 0 && y >=0  && x<AgentWorld.X && y<AgentWorld.Y;
    }

    public void setBlock(int x, int y,String map, int layer, int order,String image) throws ClientException {
        setBlock(x, y, layer, order, maps.get(map), image);
    }

    private void setBlock(int x, int y, int layer, int order, Map map, String image) throws ClientException {
        try {
            map.addImage(Game.getImage(new URL(Game.DATA_URL_BLOCKS + image)),
                                x,
                                y,
                                layer,
                                order
                               );
            
        } catch (MalformedURLException e) {
            throw new ClientException(e);
        }
    }

    public Hashtable<BlockPosition, Image> getBlocksToDraw(int layer, int order) throws ClientException {

        Hashtable<BlockPosition, Image> result = new Hashtable<BlockPosition, Image>();

        for(Map map : maps.values()){
            result.putAll(map.getBlocks(layer, order, new BlockPosition(focusPosition.getBlockX()-6, focusPosition.getBlockY()-6), new BlockSurface(X, Y)));
        }
        return result;
    }

    public BlockPosition convertBoardPositionToMapPosition(int x,int y) throws ClientException{
        return new BlockPosition(x+this.getFocusPosition().getBlockX()-(AgentWorld.X/2),
                                 y+this.getFocusPosition().getBlockY()-(AgentWorld.Y/2));
    }

    public boolean isBlockInWorld(BlockPosition mapPosition) throws ClientException {
        return isBlockInWorld(mapPosition.getBlockX(),mapPosition.getBlockY());
    }

}
