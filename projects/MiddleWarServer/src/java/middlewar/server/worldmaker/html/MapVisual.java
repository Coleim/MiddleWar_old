/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : MapVisual.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.html;

import middlewar.common.*;
import middlewar.server.worldmaker.business.*;

import java.io.IOException;
import java.io.Writer;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
 * HTML reprensentation of a map
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class MapVisual extends HtmlComplexlElement{

    private Map map; // the map to show

    /**
     * Constructor
     * @param w the world to show
     * @throws failure.wm.business.WorldException
     */
    public MapVisual(Map map) throws WorldMakerException {
        if(map==null) throw new WorldMakerException("no map to show");
        this.map = map;
    }

    @Override
    public void printHtml(Writer out) throws IOException {
        out.write("<!-- getHtml -->");
        out.write("<div class='world'>");
        /*
        for(int i=0;i<this.world.getSurface().getBlockX();i++) {
            for(int j=0;j<this.world.getSurface().getBlockY();j++) {
                if(this.world.getBlocks().containsKey(new BlockPosition(i,j))) {
                    for(int k=0;k<this.world.getBlocks().get(new BlockPosition(i,j)).size();k++) {
                        out.write(new BlockHtml(this.world.getBlocks().get(new BlockPosition(i,j)).elementAt(k)).toString());
                    }
                }
            }
        }*/

        Hashtable<MapPosition,Block> blocks = this.map.getBlocks();
        Collection<Block> list = blocks.values();
        Iterator<Block> itr = list.iterator();

        while(itr.hasNext()){
            Block b = itr.next();
            if(b.getPosition().getLayer()==0) new BlockVisual(b).printHtml(out);
        }

        itr = list.iterator();

        while(itr.hasNext()){
            Block b = itr.next();
            if(b.getPosition().getLayer()==1) new BlockVisual(b).printHtml(out);
        }

        out.write("</div>");
    }

    /*

    public void print(Writer htmlout, Writer jsout, BlockSurface surface, BlockPosition position) throws IOException {
        htmlout.write("<!-- getHtml (zone) -->");
        htmlout.write("<div class='world'>");
        for (int i = position.getBlockX(); i < surface.getBlockX() + position.getBlockX(); i++) {
            for (int j = position.getBlockY(); j < surface.getBlockY() + position.getBlockY(); j++) {
                if (this.map.getBlocks().containsKey(new BlockPosition(i, j))) {
                    for (int k = 0; k < this.map.getBlocks().get(new BlockPosition(i, j)).size(); k++) {
                        Block b = this.map.getBlocks().get(new BlockPosition(i, j)).elementAt(k);
                        BlockVisual h = new BlockVisual(this.map.getBlocks().get(new BlockPosition(i, j)).elementAt(k));
                        h.printHtml(htmlout,new BlockPosition(b.getPosition(), position));
                        h.printJs(jsout);
                    }
                } else {
                     htmlout.write("<!-- no block at " + i + "," + j + " -->\n");
                }
            }
        }
        htmlout.write("</div>");
    }

    public void printHtml(Writer out, BlockSurface surface, BlockPosition position) throws IOException {
        out.write("<!-- getHtml (zone) -->");
        out.write("<div class='world'>");
        for (int i = position.getBlockX(); i < surface.getBlockX() + position.getBlockX(); i++) {
            for (int j = position.getBlockY(); j < surface.getBlockY() + position.getBlockY(); j++) {
                if (this.world.getBlocks().containsKey(new BlockPosition(i, j))) {
                    for (int k = 0; k < this.world.getBlocks().get(new BlockPosition(i, j)).size(); k++) {
                        Block b = this.world.getBlocks().get(new BlockPosition(i, j)).elementAt(k);
                        BlockVisual h = new BlockVisual(this.world.getBlocks().get(new BlockPosition(i, j)).elementAt(k));
                        h.printHtml(out,new BlockPosition(b.getPosition(), position));
                    }
                } else {
                     out.write("<!-- no block at " + i + "," + j + " -->\n");
                }
            }
        }
        out.write("</div>");
    }


    */

    
    @Override
    public void printJs(Writer out) throws IOException {
        Hashtable<MapPosition,Block> blocks = this.map.getBlocks();

        Collection<Block> list = blocks.values();

        Iterator<Block> itr = list.iterator();

        while(itr.hasNext()){
            Block b = itr.next();
            new BlockVisual(b).printJs(out);
        }
    }

    @Override
    public void print(Writer outJs, Writer outHtml) throws IOException {
        printJs(outJs);
        printHtml(outHtml);
    }
    
}
