/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : BlockHtml.java
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

/**
 * HTML reprensentation of a block
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class BlockVisual extends HtmlComplexlElement{

    private Block block;    // the block to show

    /**
     * Constructor
     * @param block the block to show
     */
    public BlockVisual(Block block) {
        this.block = block;
    }

    /**
     * @see HtmlElement
     */
    public void printHtml(Writer out,BlockPosition position) throws IOException {
        if(this.block.getType() != null){
            out.write("<img id=\""+this.block.toString()+"\" style=\"z-index:"+(block.getPosition().getOrder()+block.getPosition().getLayer()*100)+";left: "+position.getPxX()+"px;margin-top:"+position.getPxY()+"px;\" class='world_block' src='"+this.block.getType().getFullPathImage()+"' />\n");
        }
    }

    public JsElement getJavascript(){
        JsElement elt = null;
        if(this.block.getClass().equals(BlockAnimated.class)){
            elt = new BlockAnimatedJs((BlockAnimated)this.block);
        }
        return elt;
    }

    @Override
    public void printHtml(Writer out) throws IOException {
        printHtml(out,this.block.getPosition());
    }
    @Override
    public void printJs(Writer jsout) throws IOException {
        JsElement elt = this.getJavascript();
         if(elt!=null) elt.printJs(jsout);
    }

    @Override
    public void print(Writer outJs, Writer outHtml) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
