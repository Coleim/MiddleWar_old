/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.SurfaceTypeSetBasic.java
 *
 * History :
 * 1.1     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

/**
 * Set of images, describing a surface
 * @author Higurashi
 * @version WM 1.1
 * @since WM 1.1
 */
public class SurfaceTypeSetBasic extends SurfaceTypeSet{

    public final BlockType C_I;  // centre interne
    public final BlockType C_E;  // centre externe
    public final BlockType N;   // nord
    public final BlockType S;   // sud
    public final BlockType E;   // est
    public final BlockType O;   // ouest
    public final BlockType NO;  // nord ouest
    public final BlockType SO;  // sud ouest
    public final BlockType NE;  // nord est
    public final BlockType SE;  // sud est
    public final BlockType NO_I;  // nord ouest interne
    public final BlockType NE_I;  // nord est interne
    public final BlockType SO_I;  // sud ouest interne
    public final BlockType SE_I;  // sud est interne

    public SurfaceTypeSetBasic(
            BlockType ci, BlockType ce,
            BlockType n, BlockType s, BlockType e, BlockType o,
            BlockType so, BlockType no, BlockType se, BlockType ne,
            BlockType noi, BlockType nei,
            BlockType soi, BlockType sei
    ){
        this.C_E = ce;
        this.C_I = ci;
        this.E = e;
        this.N = n;
        this.S = s;
        this.O = o;
        this.SE = se;
        this.SO = so;
        this.NE = ne;
        this.NO = no;
        this.SE_I = sei;
        this.SO_I = soi;
        this.NE_I = nei;
        this.NO_I = noi;
    }

}
