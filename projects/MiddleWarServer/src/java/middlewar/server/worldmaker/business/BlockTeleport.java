/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.BlockTeleport.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.common.*;

/**
 * Animated base element of maps
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class BlockTeleport extends Block{

    protected WorldName destinationMetaWorld;
    protected BlockPosition destinationPosition;

    /**
     * Constructor
     * @param position the position of the block
     * @param destinationMetaWorld destination (meta world)
     * @param destinationPosition destination (position)
     */
    public BlockTeleport(MapPosition position, WorldName destinationMetaWorld, BlockPosition destinationPosition) {
        super(position, BlockType.dev_teleport, true);
        this.destinationMetaWorld = destinationMetaWorld;
        this.destinationPosition = destinationPosition;
    }

    /**
     * Return the destination
     * @return the destination
     */
    public WorldName getDestinationMetaWorld() {
        return destinationMetaWorld;
    }

    /**
     * Return the destination
     * @return the destination
     */
    public BlockPosition getDestinationPosition() {
        return destinationPosition;
    }



}
