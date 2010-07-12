/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WpAnimatedSquareSurface.java
 *
 * History :
 * 1.1     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.patterns;

import middlewar.server.worldmaker.business.*;
import middlewar.common.*;

/**
 * Rectangle pattern
 * @author Higurashi
 * @version WM 1.1
 * @since WM 1.1
 */
public class WpAnimatedSquareSurface extends WorldPattern{

    protected SurfaceType[] types;     // surface of the pattern
    protected int[] delay;             // inter frame delay
    protected boolean passing;         // true if the pattern is passable

    /**
     * Constructor
     * @param x size (X)
     * @param y size (Y)
     * @param position the base position of the pattern
     * @param types[] the surface type of the pattern (ordered for animation)
     * @param delay[] the inter frames delay (ordered for animation)
     * @param passing true if the pattern is passable
     */
    public WpAnimatedSquareSurface(int x, int y,Position position,SurfaceType types[],int delay[],boolean passing) {
        super(x, y,position);
        this.types = types;
        this.delay = delay;
        this.passing = passing;
    }

    /**
     * @see WorldPattern
     */
    @Override
    public void build() throws WorldMakerException{

        // NO
        BlockType[] no_list = new BlockType[this.types.length];
        for(int i=0;i<no_list.length;i++) {
            no_list[i] = types[i].getBasicSet().NO;
        }

        // SO
        BlockType[] so_list = new BlockType[this.types.length];
        for(int i=0;i<so_list.length;i++) {
            so_list[i] = types[i].getBasicSet().SO;
        }

        // N
        BlockType[] n_list = new BlockType[this.types.length];
        for(int i=0;i<n_list.length;i++) {
            n_list[i] = types[i].getBasicSet().N;
        }

        // S
        BlockType[] s_list = new BlockType[this.types.length];
        for(int i=0;i<s_list.length;i++) {
            s_list[i] = types[i].getBasicSet().S;
        }

        // NE
        BlockType[] ne_list = new BlockType[this.types.length];
        for(int i=0;i<ne_list.length;i++) {
            ne_list[i] = types[i].getBasicSet().NE;
        }

        // SE
        BlockType[] se_list = new BlockType[this.types.length];
        for(int i=0;i<se_list.length;i++) {
            se_list[i] = types[i].getBasicSet().SE;
        }

        // E
        BlockType[] e_list = new BlockType[this.types.length];
        for(int i=0;i<e_list.length;i++) {
            e_list[i] = types[i].getBasicSet().E;
        }

        // O
        BlockType[] o_list = new BlockType[this.types.length];
        for(int i=0;i<o_list.length;i++) {
            o_list[i] = types[i].getBasicSet().O;
        }

        // C_I
        BlockType[] ci_list = new BlockType[this.types.length];
        for(int i=0;i<ci_list.length;i++) {
            ci_list[i] = types[i].getBasicSet().C_I;
        }

        this.setAnimatedBlock(0, 0, 0, no_list, delay, passing);
        this.setAnimatedBlock(0, y+1, 0, so_list, delay, passing);
        for(int j=1;j<x+1;j++) {
            this.setAnimatedBlock(j, 0, 0, n_list, delay, passing);
            this.setAnimatedBlock(j, y+1, 0, s_list, delay, passing);
        }
        this.setAnimatedBlock(x+1, 0, 0, ne_list, delay, passing);
        this.setAnimatedBlock(x+1, y+1, 0, se_list, delay, passing);

        for(int j=1;j<y+1;j++) {
            this.setAnimatedBlock(0, j, 0, o_list, delay, passing);
            this.setAnimatedBlock(x+1, j, 0, e_list, delay, passing);
        }

        for(int i=1;i<x+1;i++) {
            for(int j=1;j<y+1;j++) {
                this.setAnimatedBlock(i, j, 0, ci_list, delay, passing);
            }
        }
    }

}
