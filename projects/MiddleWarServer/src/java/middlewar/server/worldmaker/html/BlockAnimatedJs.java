/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : BlockAnimatedJs.java
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
 * JS reprensentation of a animated block
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class BlockAnimatedJs implements JsElement{

    BlockAnimated block;

    public BlockAnimatedJs(BlockAnimated block){
        this.block = block;
    }

    @Override
    public void printJs(Writer out) throws IOException {

        String functionName = "update"+this.block.getPosition().getBlockX()+""+this.block.getPosition().getBlockY();
        out.append("\n<script type=\"text/javascript\">");
        
        out.append("\nvar count_"+functionName+"=0;");
        
        out.append("\n"+functionName+"();");
        out.append("\nfunction "+functionName+"() {");

        out.append("\nvar table_"+functionName+"=[");

        BlockType[] blocks = this.block.getBlocks();

        for(int i=0;i<blocks.length-1;i++){

            out.append("\n\t\""+this.block.getBlocks()[i].getFullPathImage()+"\",");

        }
        out.append("\n\t\""+this.block.getBlocks()[blocks.length-1].getFullPathImage()+"\"");
        out.append("\n]");

        out.append("\nvar table_delay_"+functionName+"=[");

        int[] delays = this.block.getDelays();

        for(int i=0;i<delays.length-1;i++){

            out.append("\n\t"+delays[i]+",");

        }
        out.append("\n\t"+delays[delays.length-1]);
        out.append("\n]");
        out.append("\nif(document.getElementById(\""+this.block.toString()+"\") != null) {");
        out.append("\ndocument.getElementById(\""+this.block.toString()+"\").src=table_"+functionName+"[count_"+functionName+"];");
        out.append("\n}");
        out.append("\nsetTimeout(\""+functionName+"()\", table_delay_"+functionName+"[count_"+functionName+"]);");
        out.append("\ncount_"+functionName+"++;");
                out.append("\nif (count_"+functionName+">="+blocks.length+") {");
        out.append("\n\tcount_"+functionName+"=0;");
        out.append("\n}");
        out.append("\n}");
        out.append("\n</script>\n");

    }

}
