/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.animations.WorldAnimation.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.animations;

import middlewar.common.*;
import middlewar.server.worldmaker.business.*;
import java.io.Serializable;

/**
 * World Animation (see AnimationType)
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class WorldAnimation  extends Worldable implements Serializable{

    /**
     * Constructor (default position is 0,0)
     * The position is set by the world builder
     */
    public WorldAnimation() {
        super(BlockPosition.origin);
    }

}
