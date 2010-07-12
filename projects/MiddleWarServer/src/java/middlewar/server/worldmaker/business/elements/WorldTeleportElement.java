/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WorldTeleportElement.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import middlewar.common.*;
import java.io.Serializable;
import middlewar.server.worldmaker.business.*;

/**
 * World Element (see ElementType), teleport units
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class WorldTeleportElement  extends WorldElement implements Serializable{

    protected WorldName destinationMetaWorld;
    protected BlockPosition destinationPosition;

    /**
     * @see WorldElement
     * size (x, y) is set by world builder
     */
    public WorldTeleportElement() {
        super();
    }

    public void setDestinationMetaWorld(WorldName destinationMetaWorld) {
        this.destinationMetaWorld = destinationMetaWorld;
    }

    public void setDestinationPosition(BlockPosition destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    

}
