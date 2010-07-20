/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.common.BlockPosition;
import middlewar.common.Orientation;
import middlewar.server.Server;
import middlewar.server.business.player.Player;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.World;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.server.worldmaker.business.WorldName;
import middlewar.xmwp.Element;
import middlewar.xmwp.XMWPException;
import middlewar.xmwp.XMWPable;
import middlewar.xmwp.elements.inform.UnitInformElement;

/**
 * Unit of the game
 * @author higurashi
 */
public class Unit implements XMWPable{

    private String id;
    private String playerId = null;

    private int level;
    private int life;

    private BlockPosition position;
    private WorldName world;

    private UnitVisual head;
    private UnitVisual body;

    private Orientation orientation;

    public Unit(String id,String playerId, BlockPosition position, WorldName world, Orientation orientation){
        this.id = id;
        this.position = position;
        this.world = world;
        this.orientation = orientation;
        this.playerId = playerId;
    }

    public WorldName getWorld() {
        return world;
    }

    public void setWorld(WorldName world) {
        this.world = world;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public UnitVisual getBody() {
        return body;
    }

    public UnitVisual getHead() {
        return head;
    }
    
    public String getId() {
        return id;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife(){
        return this.life;
    }

    public int getLevel() {
        return level;
    }

    public BlockPosition getPosition() {
        return position;
    }

    public void setPosition(BlockPosition position) {
        this.position = position;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }




    public UnitInformElement getXMWPElement(boolean focus) throws XMWPException {
        try {
            // the world of the unit
            World w = Server.worldManager.getWorldByName(getWorld());
            // get maps
            String[] mapsNames = w.getMapForPosition(getPosition());
            // main map
            String m = mapsNames[0];

            if(focus){
                Player p = Server.playerManager.getPlayerById(playerId);
                p.setSelectedUnitId(getId());
            }

            // build the inform element
            return new UnitInformElement(getId(), getPlayerId(), m, getPosition().getBlockX(), getPosition().getBlockY(), mapsNames, focus);
        }
        catch (WorldMakerException ex) {
            ex.printStackTrace();
        }
        catch (ServerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public UnitInformElement getXMWPElement() throws XMWPException {
        return getXMWPElement(true);
    }



/*
        public List<Unit> lookForEnnemies() {
        List<Unit> ennemiesList = new ArrayList<Unit>();
        int startX = position.getBlockX() - this.getAttackRange();
        int endX = position.getBlockX() + this.getAttackRange();
        int startY = position.getBlockY() - this.getAttackRange();
        int endY = position.getBlockY() + this.getAttackRange();
        // For each block around the unit, we look if there is an ennemy unit,
        // and add it to the list.
        for( int i = startX ; i <= endX ; ++i ) {
        for( int j = startY ; j <= endY ; ++j ) {
        Unit foundUnit = GameEngine.unitManager.getUnit(new BlockPosition(i, j), this.getMetaworld());
        //A voir ce qui est plus rapide
        //if( foundUnit != null && !GameEngine.unitManager.isAlly(this, foundUnit)) {
        //    ennemiesList.add(foundUnit);
        //}
        if( foundUnit != null && !this.getArmy().belongToThisArmy(foundUnit) ) {
        ennemiesList.add(foundUnit);
        }
        }
        }
        return ennemiesList;
        }
        private List<Block> getBlocksAtRange( int range ) throws GameEngineException {
        List<Block> blockList = new ArrayList<Block>();
        int startX = position.getBlockX() - range;
        int endX = position.getBlockX() + range;
        int startY = position.getBlockY() - range;
        int endY = position.getBlockY() + range;
        // For each block around the unit, we add it to the list
        for( int x = startX ; x <= endX ; ++x ) {
        for( int y = startY ; y <= endY ; ++y ) {
        BlockPosition pos = new BlockPosition(x, y);
        blockList.addAll(GameEngine.getWorlds(metaworld)[0].getBlocks(pos));
        }
        }
        return blockList;
        }
        public List<Block> getBlocksAtAttackRange() throws GameEngineException {
        return getBlocksAtRange(this.getAttackRange());
        }
        public List<Block> getBlocksAtSupportRange() throws GameEngineException {
        return getBlocksAtRange(this.getSupportRange());
        }
         */


/*
    public List<Unit> lookForEnnemies() {
        List<Unit> ennemiesList = new ArrayList<Unit>();

        int startX = position.getBlockX() - this.getAttackRange();
        int endX = position.getBlockX() + this.getAttackRange();

        int startY = position.getBlockY() - this.getAttackRange();
        int endY = position.getBlockY() + this.getAttackRange();

        // For each block around the unit, we look if there is an ennemy unit,
        // and add it to the list.
        for( int i = startX ; i <= endX ; ++i ) {
            for( int j = startY ; j <= endY ; ++j ) {
                Unit foundUnit = GameEngine.unitManager.getUnit(new BlockPosition(i, j), this.getMetaworld());
                //A voir ce qui est plus rapide
                //if( foundUnit != null && !GameEngine.unitManager.isAlly(this, foundUnit)) {
                //    ennemiesList.add(foundUnit);
                //}
                
                if( foundUnit != null && !this.getArmy().belongToThisArmy(foundUnit) ) {
                    ennemiesList.add(foundUnit);
                }
            }
        }

        return ennemiesList;
    }


    private List<Block> getBlocksAtRange( int range ) throws GameEngineException {
        List<Block> blockList = new ArrayList<Block>();

        int startX = position.getBlockX() - range;
        int endX = position.getBlockX() + range;

        int startY = position.getBlockY() - range;
        int endY = position.getBlockY() + range;

        // For each block around the unit, we add it to the list
        for( int x = startX ; x <= endX ; ++x ) {
            for( int y = startY ; y <= endY ; ++y ) {
                BlockPosition pos = new BlockPosition(x, y);
                blockList.addAll(GameEngine.getWorlds(metaworld)[0].getBlocks(pos));
            }
        }

        return blockList;
    }

    public List<Block> getBlocksAtAttackRange() throws GameEngineException {
        return getBlocksAtRange(this.getAttackRange());
    }

    public List<Block> getBlocksAtSupportRange() throws GameEngineException {
        return getBlocksAtRange(this.getSupportRange());
    }

*/
    
}
