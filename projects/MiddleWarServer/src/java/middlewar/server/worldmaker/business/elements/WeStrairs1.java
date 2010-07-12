/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeStrairs1.java
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
public class WeStrairs1 extends WorldElement{

    @Override
    public void build() throws WorldMakerException{
         this.setBlock(0, 0, 0, BlockType.invisible,true);
         this.setBlock(1, 0, 0, BlockType.invisible,true);
         this.setBlock(0, 1, 0, BlockType.stairs_1_NO,true);
         this.setBlock(1, 1, 0, BlockType.stairs_1_NE,true);
         this.setBlock(0, 2, 0, BlockType.stairs_1_SO,true);
         this.setBlock(1, 2, 0, BlockType.stairs_1_SE,true);
    }

}
