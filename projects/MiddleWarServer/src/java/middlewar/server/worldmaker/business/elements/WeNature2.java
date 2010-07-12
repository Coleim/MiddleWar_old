/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeNature2.java
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
public class WeNature2 extends WorldElement{

    @Override
    public void build() throws WorldMakerException{

         // layer 0
         this.setBlock(0, 4, 0, BlockType.nature_2_04,true);
         this.setBlock(1, 4, 0, BlockType.nature_2_14,true);
         this.setBlock(2, 4, 0, BlockType.nature_2_24,true);
         this.setBlock(3, 4, 0, BlockType.nature_2_34,true);

         // layer 1
         this.setBlock(0, 0, 1, BlockType.nature_2_00,true);
         this.setBlock(1, 0, 1, BlockType.nature_2_10,true);
         this.setBlock(2, 0, 1, BlockType.nature_2_20,true);
         this.setBlock(3, 0, 1, BlockType.nature_2_30,true);
         this.setBlock(0, 1, 1, BlockType.nature_2_01,true);
         this.setBlock(1, 1, 1, BlockType.nature_2_11,true);
         this.setBlock(2, 1, 1, BlockType.nature_2_21,true);
         this.setBlock(3, 1, 1, BlockType.nature_2_31,true);
         this.setBlock(0, 2, 1, BlockType.nature_2_02,true);
         this.setBlock(1, 2, 1, BlockType.nature_2_12,true);
         this.setBlock(2, 2, 1, BlockType.nature_2_22,true);
         this.setBlock(3, 2, 1, BlockType.nature_2_32,true);
         this.setBlock(0, 3, 1, BlockType.nature_2_03,true);
         this.setBlock(1, 3, 1, BlockType.nature_2_13,true);
         this.setBlock(2, 3, 1, BlockType.nature_2_23,true);
         this.setBlock(3, 3, 1, BlockType.nature_2_33,true);
    }

}
