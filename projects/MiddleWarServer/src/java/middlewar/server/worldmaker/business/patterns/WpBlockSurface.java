/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WpBlockSurface.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.patterns;

import middlewar.server.worldmaker.business.*;
import middlewar.common.*;

/**
 * Rectangle pattern of one block type
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WpBlockSurface extends WorldPattern{

    protected BlockType type;       // the type of block used for pattern
    protected boolean passing;      // true if the pattern is passable

    /**
     * Constructor
     * @param x size (X)
     * @param y size (Y)
     * @param position the base position of the pattern
     * @param type the block type of the pattern
     * @param passing true if the pattern is passable
     */
    public WpBlockSurface(int x, int y,Position position,BlockType type,boolean passing) {
        super(x, y,position);
        this.type = type;
        this.passing = passing;
    }
    
    /**
     * @see WorldPattern
     */
    @Override
    public void build() throws WorldMakerException{
         for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                this.setBlock(i,j,0,type,passing);
            }
        }
    }

}
