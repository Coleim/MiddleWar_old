/*
 * Middle War - Server
 *
 */
package middlewar.server.business.world;

import middlewar.common.*;
import middlewar.server.worldmaker.business.*;

/**
 * Part of world builder
 * @author higurashi
 */
public abstract class WorldPartBuilder {

    protected Map map;
    protected MapBuilder mb;

    public abstract void generate() throws WorldMakerException;

    public WorldPartBuilder() throws WorldMakerException {
        String name = this.getClass().getName();
        map = new Map(World.MAP_SURFACE,name);
        mb = new MapBuilder(map);
    }

    protected void build() throws WorldMakerException{
        mb.buildWorld();
    }

    public Map getMap() throws WorldMakerException{
        this.generate();
        this.build();
        return this.map;
    }

    protected void addElement(BlockPosition position,ElementType type) throws WorldMakerException {
        this.mb.addElement(position, type);
    }

    protected void addAnimation(BlockPosition position, AnimationType type) throws WorldMakerException {
        this.mb.addAnimation(position, type);
    }

    protected void addBlock(BlockPosition position,BlockType type) throws WorldMakerException {
        this.mb.addSimpleBlock(position, type);
    }

    protected void addPatternCustom(Position position, SurfaceType surface, int level,int[][] mapping,boolean passing) throws WorldMakerException {
        this.mb.addPatternCustom(position, surface, level, mapping, passing );
    }

    protected void addTeleportElement(BlockPosition position, ElementType element, WorldName destinationMetaWorld, BlockPosition destinationPosition) throws WorldMakerException {
        this.mb.addTeleportElement(position, element, destinationMetaWorld, destinationPosition );
    }

    protected void addPatternSquare(BlockSurface surface, BlockPosition position, SurfaceType type, boolean passing) throws WorldMakerException{
        this.mb.addPatternSquare(surface.getBlockX(), surface.getBlockY(), position, type, passing);
    }

    protected void addPatternBlock(BlockSurface surface, BlockPosition position, BlockType type, boolean passing) throws WorldMakerException{
        this.mb.addPatternBlock(surface.getBlockX(), surface.getBlockY(), position, type, passing);
    }

    protected void addPatternWall(BlockSurface surface, BlockPosition position, SurfaceType type, boolean passing) throws WorldMakerException{
        this.mb.addPatternWall(surface.getBlockX(), surface.getBlockY(), position, type, passing);
    }

}

