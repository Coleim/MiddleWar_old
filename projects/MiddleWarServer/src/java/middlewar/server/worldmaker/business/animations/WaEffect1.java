/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WaEffect1.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.animations;

import middlewar.server.worldmaker.business.*;

/**
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WaEffect1 extends WorldAnimation{

    protected boolean passing;
    protected BlockType[] blocks = null;

    @Override
    public void build() throws WorldMakerException{

        int[] delays = { 200, 200, 200, 200 };
        this.blocks = new BlockType[4];
        this.blocks[0] = BlockType.animation_effect_1_f1;
        this.blocks[1] = BlockType.animation_effect_1_f2;
        this.blocks[2] = BlockType.animation_effect_1_f3;
        this.blocks[3] = BlockType.animation_effect_1_f4;
        this.setAnimatedBlock(0, 0, 0, this.blocks,delays,this.passing);
    }

}
