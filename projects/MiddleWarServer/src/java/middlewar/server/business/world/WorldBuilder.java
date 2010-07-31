/*
 * Middle War - Server
 *
 */

package middlewar.server.business.world;

import middlewar.server.business.world.parts.*;
import middlewar.server.worldmaker.business.*;
import middlewar.common.*;
import middlewar.server.Server;

/**
 * World (set of map) builder
 * @author higurashi
 */
public class WorldBuilder {

    private WorldPartBuilder[][] list;
    private WorldName name;

    /**
     * Create a new WorldBulder
     * @param name the name of the world
     */
    public WorldBuilder(WorldName name){

        this.name = name;

        try {

            // Link worlds with maps
            switch(name){

                case test1 : {
                    list = new WorldPartBuilder[2][2];
                    list[0][0] = new test1_0("basic1");        
                    list[0][1] = new test1_2("basic2");
                    list[1][1] = new test1_3("basic3");
                    list[1][0] = new test1_1("basic4");
                }break;

                case test2 : {
                    list = new WorldPartBuilder[1][1];
                    list[0][0] = new test1_0("basic5");
                }break;
                
            }

        } catch (WorldMakerException e) {
            Server.logs.logError(e);
        }
    }

    /**
     * Return the name of the world
     * @return the world name
     */
    public WorldName getName() {
        return name;
    }

    /**
     * Generate the world
     * @return the world object
     * @throws WorldMakerException
     */
    public World generate() throws WorldMakerException {

        World mw = new World(this.name);

        int sizeX = World.MAP_SURFACE.getBlockX();
        int sizeY = World.MAP_SURFACE.getBlockY();

        for(int i=0;i<this.list.length;i++) {
            for(int j=0;j<this.list[i].length;j++) {
                if(this.list[i][j] != null){
                    Map m = this.list[i][j].getMap();
                    mw.addMap(m, new BlockPosition(i*sizeX, j*sizeY));
                }
            }
        }

        return mw;
    }

}
