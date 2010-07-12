/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.BlockAnimated.java
 *
 * History :
 * 1.0     : Add to wm, basic fonctions
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
public class BlockAnimated extends Block{

    protected int[] delays;             // inter frames delays
    protected BlockType[] blocks;       // frames

    /**
     * Constructor
     * @param position the position of the block
     * @param blocks the frames of the animation
     * @param delays the inter frames delays
     * @param passing true if it's possible to pass over the animation
     */
    public BlockAnimated(MapPosition position, BlockType[] blocks, int[] delays, boolean passing) {
        super(position, blocks[0], passing);
        this.delays = delays;
        this.blocks = blocks;
    }

    /**
     * Return the blocks (one per frame)
     * @return the blocks
     */
    public BlockType[] getBlocks() {
        return blocks;
    }

    /**
     * Return the inter frames delays
     * @return the delays
     */
    public int[] getDelays() {
        return delays;
    }

}
