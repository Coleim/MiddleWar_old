/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

/**
 * @see Position
 * @author higurashi
 */
public class MapPosition extends BlockPosition{

    private String map;
    private int layer = 0;
    private int order = 0;

    public MapPosition(int x, int y, int layer, int order, String map) {
        super(x, y);
        this.layer = layer;
        this.order = order;
        this.map = map;
    }

    public int compareTo(MapPosition p) {
        if(this.x==p.x &&
           this.y==p.y &&
           map.equals(p.map) &&
           this.order == p.order &&
           this.layer == p.layer
        ) return 0; else return -1;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof MapPosition) {
            if(this.compareTo((MapPosition)anObject) == 0) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Integer.parseInt(new String(x+"0"+y+"0"+(layer*order)).replace("-", ""));
        return hash;
    }

    @Override
    public MapPosition add(BlockPosition position) {
        MapPosition p = new MapPosition(this.getBlockX(),this.getBlockY(),
                                        this.layer,this.order,this.map);
        p.x += position.x;
        p.y += position.y;
        return p;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}

