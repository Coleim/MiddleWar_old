/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WpSquareSurface.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.patterns;

import middlewar.server.worldmaker.business.*;
import middlewar.common.*;

/**
 * Rectangle pattern
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WpSquareSurface extends WorldPattern{

    protected SurfaceType type;     // surface of the pattern
    protected boolean passing;      // true if the pattern is passable

    /**
     * Constructor
     * @param x size (X)
     * @param y size (Y)
     * @param position the base position of the pattern
     * @param type the surface type of the pattern
     * @param passing true if the pattern is passable
     */
    public WpSquareSurface(int x, int y,Position position,SurfaceType type,boolean passing) {
        super(x, y,position);
        this.type = type;
        this.passing = passing;
    }

    /**
     * @see WorldPattern
     */
    @Override
    public void build() throws WorldMakerException{
        this.setBlock(0, 0, 0, type.getBasicSet().NO,this.passing);
        this.setBlock(0, y+1, 0, type.getBasicSet().SO,this.passing);
        for(int j=1;j<x+1;j++) {
            this.setBlock(j, 0, 0, type.getBasicSet().N,this.passing);
            this.setBlock(j, y+1, 0, type.getBasicSet().S,this.passing);
        }
        this.setBlock(x+1, 0, 0, type.getBasicSet().NE,this.passing);
        this.setBlock(x+1, y+1, 0, type.getBasicSet().SE,this.passing);

        for(int j=1;j<y+1;j++) {
            this.setBlock(0, j, 0, type.getBasicSet().O,this.passing);
            this.setBlock(x+1, j, 0, type.getBasicSet().E,this.passing);
        }

        for(int i=1;i<x+1;i++) {
            for(int j=1;j<y+1;j++) {
                this.setBlock(i, j, 0, type.getBasicSet().C_I,this.passing);
            }
        }
    }

}
