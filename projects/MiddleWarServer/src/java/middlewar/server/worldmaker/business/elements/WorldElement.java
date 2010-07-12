/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WorldElement.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import middlewar.common.*;
import middlewar.server.worldmaker.business.*;
import java.io.Serializable;

/**
 * World Element (see ElementType)
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class WorldElement  extends Worldable implements Serializable{

    /**
     * Constructor (default position is 0,0)
     * The position is set by the world builder
     */
    public WorldElement() {
        super(BlockPosition.origin);
    }

}
