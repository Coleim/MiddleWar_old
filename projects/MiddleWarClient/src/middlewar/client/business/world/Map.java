/*
 * Middle War Client
 *
 */

package middlewar.client.business.world;

import java.awt.Image;
import java.util.Hashtable;
import java.util.Vector;
import middlewar.client.business.Game;
import middlewar.common.*;
import middlewar.client.exception.ClientException;

/**
 * Store world data
 * @author higurashi
 */
public class Map {

    private String name;

    // World layer down
    private Hashtable<BlockPosition,Image> blocksLayer0_0 = new Hashtable<BlockPosition,Image>();
    private Hashtable<BlockPosition,Image> blocksLayer0_1 = new Hashtable<BlockPosition,Image>();
    private Hashtable<BlockPosition,Image> blocksLayer0_2 = new Hashtable<BlockPosition,Image>();
    private Hashtable<BlockPosition,Image> blocksLayer0_3 = new Hashtable<BlockPosition,Image>();

    // world layer up
    private Hashtable<BlockPosition,Image> blocksLayer1_0 = new Hashtable<BlockPosition,Image>();

    // passing
    private Hashtable<BlockPosition,Boolean> sep_up = new Hashtable<BlockPosition, Boolean>();
    private Hashtable<BlockPosition,Boolean> sep_down = new Hashtable<BlockPosition, Boolean>();
    private Hashtable<BlockPosition,Boolean> sep_right = new Hashtable<BlockPosition, Boolean>();
    private Hashtable<BlockPosition,Boolean> sep_left = new Hashtable<BlockPosition, Boolean>();


    public Map(String name) throws ClientException {
        this.name = name;
    }

    public void addSeparation(int x, int y,Orientation orientation){
        switch(orientation){
            case UP : sep_up.put(new BlockPosition(x, y), false); break;
            case DOWN : sep_down.put(new BlockPosition(x, y), false); break;
            case RIGHT : sep_right.put(new BlockPosition(x, y), false); break;
            case LEFT : sep_left.put(new BlockPosition(x, y), false); break;
        }
    }

    public boolean isPassing(int x,int y,Orientation orientation){
        switch(orientation){
            case UP :
                if(sep_up.containsKey(new BlockPosition(x, y)))
                return sep_up.get(new BlockPosition(x, y));
                else return true;
            case DOWN :
                if(sep_down.containsKey(new BlockPosition(x, y)))
                return sep_down.get(new BlockPosition(x, y));
                else return true;
            case RIGHT :
                if(sep_right.containsKey(new BlockPosition(x, y)))
                return sep_right.get(new BlockPosition(x, y));
                else return true;
            case LEFT :
                if(sep_left.containsKey(new BlockPosition(x, y)))
                return sep_left.get(new BlockPosition(x, y));
                else return true;
            default: return true;
        }
    }

    public void addImage(Image image,int x, int y,int layer,int order) throws ClientException {

        if(layer == 0){
            switch(order){
                case 0 : blocksLayer0_0.put(new BlockPosition(x, y), image); break;
                case 1 : blocksLayer0_1.put(new BlockPosition(x, y), image); break;
                case 2 : blocksLayer0_2.put(new BlockPosition(x, y), image); break;
                case 3 : blocksLayer0_3.put(new BlockPosition(x, y), image); break;
                default: throw new ClientException("NO LAYER '"+layer+"' / order '"+order+"'");
            }
        }else if(layer==1){
            blocksLayer1_0.put(new BlockPosition(x, y), image);
        }else{
            throw new ClientException("NO LAYER "+layer);
        }
        System.out.println("add block"+blocksLayer0_0.size()+","+blocksLayer0_1.size()+","+blocksLayer0_2.size());
    }

    public Hashtable<BlockPosition,Image> getBlocks(int layer,int order) throws ClientException {
        
        if(layer == 0){
            switch(order){
                case 0 : return blocksLayer0_0;
                case 1 : return blocksLayer0_1;
                case 2 : return blocksLayer0_2;
                case 3 : return blocksLayer0_3;
                default: throw new ClientException("NO LAYER '"+layer+"' / order '"+order+"'");
            }
        }else if(layer == 1){
            return blocksLayer1_0;
        }else{
            throw new ClientException("NO LAYER "+layer);
        }
        
    }

    public Hashtable<BlockPosition,Image> getBlocks(int layer,int order, BlockPosition origin, BlockSurface surface) throws ClientException {

        Hashtable<BlockPosition,Image> list;
        Hashtable<BlockPosition,Image> result = new Hashtable<BlockPosition, Image>(surface.getBlockX()*surface.getBlockY());

        if(layer == 0){
            switch(order){
                case 0 : list = blocksLayer0_0; break;
                case 1 : list =  blocksLayer0_1; break;
                case 2 : list =  blocksLayer0_2; break;
                case 3 : list = blocksLayer0_3; break;
                default: throw new ClientException("NO LAYER '"+layer+"' / order '"+order+"'");
            }
        }else if(layer == 1){
            list =  blocksLayer1_0;
        }else{
            throw new ClientException("NO LAYER "+layer);
        }

        BlockPosition bp;
        int sx = surface.getBlockX();
        int sy = surface.getBlockY();
        for(int x=0;x<sx;x++){
            for(int y=0;y<sy;y++){
                bp = new BlockPosition(origin.getBlockX()+x, origin.getBlockY()+y);
                if(list.containsKey(bp)) result.put(bp, list.get(bp));
            }
        }

        return result;

    }

    public Image[] getBlock(int x, int y, int layer,String world) throws ClientException {
        return this.getBlock(new BlockPosition(x, y), layer);
    }

    public Image[] getBlock(BlockPosition position, int layer) throws ClientException{

        Vector<Image> list = new Vector<Image>(3);

        if(layer == 0){
            if(blocksLayer0_0.containsKey(position)) list.add(blocksLayer0_0.get(position));
            if(blocksLayer0_1.containsKey(position)) list.add(blocksLayer0_1.get(position));
            if(blocksLayer0_2.containsKey(position)) list.add(blocksLayer0_2.get(position));
            if(blocksLayer0_3.containsKey(position)) list.add(blocksLayer0_3.get(position));
        }else if(layer == 1){
            if(blocksLayer1_0.containsKey(position)) list.add(blocksLayer1_0.get(position));
        }else{
            throw new ClientException("NO LAYER "+layer);
        }

        return list.toArray(new Image[list.size()]);
        
    }

    public Orientation getBorder(int x, int y) {
        //if(y == 0) return Orientation.UP;
        //if(y == World.y - 1) return Orientation.DOWN;
        //if(x == 0) return Orientation.LEFT;
        //if(x == World.x - 1) return Orientation.RIGHT;
        return null;
    }

    public String getName() {
        return name;
    }

    

}
