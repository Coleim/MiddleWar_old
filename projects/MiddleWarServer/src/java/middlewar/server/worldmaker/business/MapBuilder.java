/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.MapBuilder.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.server.worldmaker.business.animations.*;
import middlewar.server.worldmaker.business.patterns.*;
import middlewar.server.worldmaker.business.elements.*;
import middlewar.common.*;
import java.util.Vector;

/**
 * Map builder (apply modifications to map)
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class MapBuilder {

    private Map map;           // world to modify
    private Vector<Worldable> ws;   // modifications

    /**
     * Constructor
     * @param world the world to modify
     * @throws failure.wm.business.WorldException
     */
    public MapBuilder(Map map) throws WorldMakerException {
        this.map = map;
        this.ws = new Vector<Worldable>();
    }

    /**
     * Return the map
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    /**
     * Add a modification element
     * @param w the modificator
     */
    private void addWorldable(Worldable w) {
        w.setMap(map);
        this.ws.add(w);
    }

    /**
     * Add a animation to the map
     * @param animation the animation to add
     */
    private void addAnimation(WorldAnimation animation) {
        addWorldable(animation);
    }

    /**
     * Add a pattern to the map
     * @param pattern the pattern to add
     */
    private void addPattern(WorldPattern pattern) {
        addWorldable(pattern);
    }

    /**
     * Add a element to the map
     * @param element the element to add
     */
    private void addElement(WorldElement element) {
        addWorldable(element);
    }

    /**
     * Apply modifications
     * @return the world
     * @throws failure.wm.business.WorldException
     */
    public Map buildWorld() throws WorldMakerException{
        for(int i=0;i<ws.size();i++){
            //if(Constains.debugWorldCreation) System.out.print("[wb] starting building world at "+ws.get(i).getPosition()+" : ");
            ws.get(i).build();
            //if(Constains.debugWorldCreation) System.out.println("done");
        }
        //if(Constains.debugWorldCreation) System.out.println("[wb] world build :D size="+this.world.getSurface()+"");
        return map;
    }

    /**
     * PATTERN - CUSTOM
     * @see WpCustomSurface
     */
    public void addPatternCustom(Position position, SurfaceType surface, int level,int[][] description,boolean passing) throws WorldMakerException {
        this.addPattern(new WpCustomSurface(position,surface,level,description,passing,0));
    }

    /**
     * PATTERN - SQUARE
     * @see WpSquareSurface
     */
    public void addPatternSquare(int x, int y,Position position,SurfaceType type,boolean passing) throws WorldMakerException {
        this.addPattern(new WpSquareSurface(x,y,position,type,passing));
    }

    /**
     * PATTERN - BLOCK
     * @see WpBlockSurface
     */
    public void addPatternBlock(int x, int y,Position position,BlockType type,boolean passing) throws WorldMakerException {
        this.addPattern(new WpBlockSurface(x,y,position,type,passing));
    }

    /**
     * PATTERN - WALL
     * @see WpWallSurface
     */
    public void addPatternWall(int x, int y,Position position,SurfaceType type,boolean passing) throws WorldMakerException {
        this.addPattern(new WpWallSurface(x, y, position, type, passing));
    }

    /**
     * SIMPLE BLOCK
     * @see ElementType
     */
    public void addSimpleBlock(Position position,BlockType block) throws WorldMakerException {
        this.addSimpleBlock(position, block, true);
    }

    /**
     * SIMPLE BLOCK
     * @see ElementType
     */
    public void addSimpleBlock(Position position,BlockType block,boolean passing) throws WorldMakerException {
        this.addPatternBlock(1, 1, position, block, passing);
    }

    /**
     * ELEMENT
     * @see ElementType
     */
    public void addElement(Position position,ElementType type) throws WorldMakerException {
        try {
            if(type.getElementClass()==null) throw new WorldMakerException("Element "+type.name()+" is unknown");
            WorldElement e = (WorldElement) type.getElementClass().newInstance(); 
            e.setPosition(position);
            this.addElement(e);
        } catch (InstantiationException e) {
            throw new WorldMakerException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new WorldMakerException(e.getMessage());
        }
    }

    /**
     * ELEMENT - SIZABLE
     * @see ElementType
     */
    public void addSizableElement(Position position,ElementType type,int x,int y) throws WorldMakerException {
        try {
            if(type.getElementClass()==null) throw new WorldMakerException("Element "+type.name()+" is unknown");
            WorldSizableElement e = (WorldSizableElement) type.getElementClass().newInstance();
            e.setPosition(position);
            e.setX(x);
            e.setY(y);
            this.addElement(e);
        } catch (InstantiationException e) {
            throw new WorldMakerException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new WorldMakerException(e.getMessage());
        }
    }

    /**
     * ELEMENT - TELEPORT
     * @see ElementType
     */
    public void addTeleportElement(Position position,ElementType type, WorldName destinationMetaWorld, BlockPosition destinationPosition) throws WorldMakerException {
        try {
            if(type.getElementClass()==null) throw new WorldMakerException("Element "+type.name()+" is unknown");
            WorldTeleportElement e = (WorldTeleportElement) type.getElementClass().newInstance();
            e.setPosition(position);
            e.setDestinationMetaWorld(destinationMetaWorld);
            e.setDestinationPosition(destinationPosition);
            this.addElement(e);
        } catch (InstantiationException e) {
            throw new WorldMakerException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new WorldMakerException(e.getMessage());
        }
    }


    /**
     * ANIMATION
     * @see WpCustomSurface
     */
    public void addAnimation(Position position,AnimationType type) throws WorldMakerException {
        try {
            if(type.getElementClass()==null) throw new WorldMakerException("Animation "+type.name()+" is unknown");
            WorldAnimation a = (WorldAnimation) type.getElementClass().newInstance();
            a.setPosition(position);
            this.addAnimation(a);

        } catch (InstantiationException e) {
            throw new WorldMakerException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new WorldMakerException(e.getMessage());
        }
    }
}
