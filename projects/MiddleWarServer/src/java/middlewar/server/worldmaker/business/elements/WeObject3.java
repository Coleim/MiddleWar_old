/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeObject3.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import middlewar.server.worldmaker.business.*;

/**
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WeObject3 extends WorldSizableElement{

    @Override
    public void build() throws WorldMakerException{

        // layer 0

        for(int j=1;j<y+2;j++) {
            this.setBlock(0, j, 0, BlockType.object_3_CO,true);
            this.setBlock(x+1, j, 0, BlockType.object_3_CE,true);
        }

        for(int i=1;i<x+1;i++) {
            for(int j=1;j<y+2;j++) {
                this.setBlock(i, j, 0, BlockType.object_3_C,true);
            }
        }

        this.setBlock(0, 0, 0, BlockType.object_3_NO,false);
        this.setBlock(0, y+1, 0, BlockType.object_3_CO,true);
        this.setBlock(0, y+2, 0, BlockType.object_3_SO,false);

        for(int j=1;j<x+1;j++) {
            this.setBlock(j, 0, 0, BlockType.object_3_NC,false);
            this.setBlock(j, y+1, 0, BlockType.object_3_C,true);
            this.setBlock(j, y+2, 0, BlockType.object_3_SC,false);
        }

        this.setBlock(x+1, 0, 0, BlockType.object_3_NE,false);
        this.setBlock(x+1, y+1, 0, BlockType.object_3_CE,true);
        this.setBlock(x+1, y+2, 0, BlockType.object_3_SE,false);

        // layer 1

        this.setBlock(0, y+1, 1, BlockType.object_3_BNO,true);
        this.setBlock(0, y+2, 1, BlockType.object_3_BSO,false);

        for(int j=1;j<x+1;j++) {
            this.setBlock(j, y+1, 1, BlockType.object_3_BNC,true);
            this.setBlock(j, y+2, 1, BlockType.object_3_BSC,false);
        }

        this.setBlock(x+1, y+1, 1, BlockType.object_3_BNE,true);
        this.setBlock(x+1, y+2, 1, BlockType.object_3_BSE,false);

    }

}
