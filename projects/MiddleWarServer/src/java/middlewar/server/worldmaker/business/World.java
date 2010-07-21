/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.BlockType.java
 *
 * History :
 * 1.0     : Add to wm, 2 layers, auto-update, auto-serialization
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.common.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Vector;
import middlewar.server.exception.ServerException;

/**
 * Set of maps. This class allow to connect maps of same sizes
 * they is tow layers in a meta world ( see metaworld doc for details )
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class World implements Serializable{

    public static final BlockSurface MAP_SURFACE = new BlockSurface(25, 25);

    // used for worlds serialisations
    public static final String WORLD_EXT = ".world";
    public static final String WORLD_PATH = "/tmp/";
    public static final String MAP_EXT = ".map";
    public static final String MAP_PATH = "/tmp/";

    // files of worlds ( index = start NO position of world )
    private Hashtable<BlockPosition,String> maps;
    private Hashtable<String,Calendar> updates;

    private WorldName name;

    /**
     * Constructor
     */
    public World(WorldName name) {
        this.name = name;
        maps = new Hashtable<BlockPosition, String>();
        updates = new Hashtable<String, Calendar>();
    }

    public Hashtable<BlockPosition, String> getMaps() {
        return maps;
    }

    /**
     * Add a world ( to layer 0 ) , the world is serialized.
     * @param world the world to add
     * @param position the NO position of the world ( in the meta-world )
     * @throws failure.wm.business.WorldException
     */
    public void addMap(Map world,BlockPosition position) throws WorldMakerException {
        //if(Constains.debugWorld) System.out.println("[mw] add world / layer 0 "+world.getName()+"@"+position);
        if(!world.getSurface().equals(MAP_SURFACE))
            throw new WorldMakerException("worlds must be "+MAP_SURFACE+" to be add");
        maps.put(position, world.getName());
        world.move(position);
        saveMap(world);
        updates.put(world.getName()+".0", world.getCreation());
    }

    /**
     * Return the name(s) of world(s) for a given position in the meta-world,
     * for layer 0
     * @param position the position in the meta-world (NO of the world)
     * @return the name(s) of world(s)
     * @throws failure.wm.business.WorldException
     */
    public String[] getMapForPosition(BlockPosition position) throws WorldMakerException {
        return getMapForPosition(position,maps);
    }

    /**
     * Return the file of a serialzed world (layer 0)
     * @param name the name of the world
     * @return the file name
     */
    public static String getMapFileByName(String name){
        return MAP_PATH+name+MAP_EXT;
    }

    public static String getWorldFileByName(String name){
        return WORLD_PATH+name+WORLD_EXT;
    }

    /**
     * Tell if there is a update needed for a world ( for layer 0 )
     * @param  world the world to test
     * @return True if need a update
     * @throws failure.wm.business.WorldException
     */
    public boolean needUpdate(Map world) throws WorldMakerException{
        return needUpdate(world, world.getName());
    }

    /**
     * Used to test worlds (private)
     * @param World the world
     * @param name the world name
     * @return True if need a update
     * @throws failure.wm.business.WorldException
     */
    private boolean needUpdate(Map world,String name) throws WorldMakerException{
        if(updates.get(name) == null){
            //if(Constains.debugWorld) System.out.println("[mw] unknown world "+name);
            return true;
            //throw new WorldException("unknown world "+newW+" (not in metaworld for now)");
        }
        if((world.getCreation().compareTo(updates.get(name))) < 0) return true; else return false;
    }

    /**
     * Return the name(s) of world(s) for a given position in a list of worlds
     * @param position the position
     * @param worlds the list of worlds
     * @return the worlds names
     * @throws failure.wm.business.WorldException
     */
    private static String[] getMapForPosition(BlockPosition position,Hashtable<BlockPosition,String> worlds) throws WorldMakerException {
        int margue = 11;

        //if(Constains.debugWorld) System.out.println("[mw] get worlds for position "+position);

        int x = getXMapPosition(position);

        int y = getYMapPosition(position);

        Vector<String> world = new Vector<String>();

        String w = worlds.get(new BlockPosition(x, y));
        if(w != null) world.add(w);

        boolean H = false;
        boolean B = false;
        boolean G = false;
        boolean D = false;

        if(position.getBlockX() > x + MAP_SURFACE.getBlockX() - margue){
           w = worlds.get(new BlockPosition(x+MAP_SURFACE.getBlockX(), y));
           if(w != null) world.add(w);
           D = true;
        }

        if(position.getBlockX() < x + margue){
           w = worlds.get(new BlockPosition(x-MAP_SURFACE.getBlockX(), y));
           if(w != null) world.add(w);
           G = true;
        }

        if(position.getBlockY() > y + MAP_SURFACE.getBlockY() - margue){
           w = worlds.get(new BlockPosition(x, y+MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
           B = true;
        }

        if(position.getBlockY() < y + margue){
           w = worlds.get(new BlockPosition(x, y-MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
           H = true;
        }

        if(D && B){
           w = worlds.get(new BlockPosition(x+MAP_SURFACE.getBlockX(), y+MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
        }

        if(D && H){
           w = worlds.get(new BlockPosition(x+MAP_SURFACE.getBlockX(), y-MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
        }

        if(G && H){
           w = worlds.get(new BlockPosition(x-MAP_SURFACE.getBlockX(), y-MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
        }

        if(G && B){
           w = worlds.get(new BlockPosition(x-MAP_SURFACE.getBlockX(), y+MAP_SURFACE.getBlockY()));
           if(w != null) world.add(w);
        }
        //if(position.getBlockX() < MAP_SURFACE.getBlockX() + margue) world.add(worlds.get(new BlockPosition(x-MAP_SURFACE.getBlockX(), y)));
        //if(w == null) throw new WorldException("no world found starting "+x+","+y+" @position "+position);
        //World result = loadWorld(world)

        return world.toArray(new String[world.size()]);
    }

    /**
     * Serialize a map
     * @param map the map to save
     */
    public void saveMap(Map map) {
        WorldMakerSerializer.save(map, getMapFileByName(map.getName()));
    }

    /**
     * Load a world
     * @param name the world name
     * @return world
     */
    public static World loadWord(WorldName name) throws ServerException{
        return WorldMakerSerializer.loadWorld(getWorldFileByName(name.name()));
    }

    /**
     * Save the world
     */
    public void save() {
        WorldMakerSerializer.save(this, getWorldFileByName(name.name()));
    }

    /**
     * Deserialize a world (layer 0)
     * @param name the world name
     * @return the world
     */
    public static Map loadMap(String name) throws ServerException {
        return WorldMakerSerializer.loadMap(getMapFileByName(name));
    }

    /**
     * Return the names of maps
     * @return the names
     */
    public String[] getMapsNames(){
        String[] names = new String[this.maps.values().size()];
        return this.maps.values().toArray(names);
    }

    private static int getXMapPosition(BlockPosition position) {
        int x =( (position.getBlockX()
          -(position.getBlockX()%MAP_SURFACE.getBlockX()))
          /MAP_SURFACE.getBlockX() ) * MAP_SURFACE.getBlockX();
        return x;
    }

    private static int getYMapPosition(BlockPosition position) {
        int y =( (position.getBlockY()
          -(position.getBlockY()%MAP_SURFACE.getBlockY()))
          /MAP_SURFACE.getBlockY() ) * MAP_SURFACE.getBlockY();
        return y;
    }

    public static BlockPosition getMapPosition(BlockPosition position) {
        return new BlockPosition(getXMapPosition(position), getYMapPosition(position));
    }


}
