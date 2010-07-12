/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeNature1.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import middlewar.server.worldmaker.business.*;
import middlewar.server.worldmaker.business.WorldMakerException;

/**
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WeNature1 extends WorldElement{

    @Override
    public void build() throws WorldMakerException{

         // layer 0
         this.setBlock(0, 4, 0, BlockType.nature_1_04,true);
         this.setBlock(1, 4, 0, BlockType.nature_1_14,true);
         this.setBlock(2, 4, 0, BlockType.nature_1_24,true);
         this.setBlock(3, 4, 0, BlockType.nature_1_34,true);

         // layer 1
         this.setBlock(0, 0, 1, BlockType.nature_1_00,true);
         this.setBlock(1, 0, 1, BlockType.nature_1_10,true);
         this.setBlock(2, 0, 1, BlockType.nature_1_20,true);
         this.setBlock(3, 0, 1, BlockType.nature_1_30,true);
         this.setBlock(0, 1, 1, BlockType.nature_1_01,true);
         this.setBlock(1, 1, 1, BlockType.nature_1_11,true);
         this.setBlock(2, 1, 1, BlockType.nature_1_21,true);
         this.setBlock(3, 1, 1, BlockType.nature_1_31,true);
         this.setBlock(0, 2, 1, BlockType.nature_1_02,true);
         this.setBlock(1, 2, 1, BlockType.nature_1_12,true);
         this.setBlock(2, 2, 1, BlockType.nature_1_22,true);
         this.setBlock(3, 2, 1, BlockType.nature_1_32,true);
         this.setBlock(0, 3, 1, BlockType.nature_1_03,true);
         this.setBlock(1, 3, 1, BlockType.nature_1_13,true);
         this.setBlock(2, 3, 1, BlockType.nature_1_23,true);
         this.setBlock(3, 3, 1, BlockType.nature_1_33,true);

    }

}
