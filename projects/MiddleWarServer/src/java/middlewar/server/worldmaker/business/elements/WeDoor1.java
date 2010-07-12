/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeDoor1.java
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
public class WeDoor1 extends WorldTeleportElement{

    @Override
    public void build() throws WorldMakerException{
         this.setBlock(0, 0, 0, BlockType.door_1_NO,false);
         this.setBlock(1, 0, 0, BlockType.door_1_N,false);
         this.setBlock(2, 0, 0, BlockType.door_1_NE,false);
         this.setBlock(0, 1, 0, BlockType.door_1_SO,false);
         this.setBlock(1, 1, 0, BlockType.door_1_S,true);
         this.setBlock(2, 1, 0, BlockType.door_1_SE,false);
         this.setTeleportBlock(1, 1, 0, this.destinationMetaWorld, this.destinationPosition);
    }

}
