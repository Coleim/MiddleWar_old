/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeObject1.java
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
public class WeObject1 extends WorldElement{

    @Override
    public void build() throws WorldMakerException{
         
         this.setBlock(0, 0, 0, BlockType.object_1_C,false);
         
    }

}
