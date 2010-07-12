/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.BlockCollision.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.common.*;

/**
 * Collision base element of maps
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class BlockCollision extends Block{

    protected Orientation orientation;

    /**
     * Constructor
     * @param position the position of the block
     * @param orientation orientation of the collision (meta world)
     */
    public BlockCollision(MapPosition position, Orientation orientation) {
        super(position, null, true);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }


}
