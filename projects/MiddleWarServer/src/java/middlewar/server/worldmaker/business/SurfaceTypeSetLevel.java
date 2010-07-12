/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.SurfaceTypeSetLevel.java
 *
 * History :
 * 1.1     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

/**
 * Set of images, describing a surface (wall / levels set)
 * @author Higurashi
 * @version WM 1.1
 * @since WM 1.1
 */
public class SurfaceTypeSetLevel extends SurfaceTypeSet{

    public final BlockType N_U;  // nord up
    public final BlockType S_U;  // sud up
    public final BlockType E_U;  // est up
    public final BlockType O_U;  // ouest up
    public final BlockType NE_U;  // nord est up
    public final BlockType SE_U;  // sud est up
    public final BlockType NO_U;  // nord ouest up
    public final BlockType SO_U;  // sud ouest up
    public final BlockType NE_I_U;  // nord est up
    public final BlockType SE_I_U;  // sud est up
    public final BlockType NO_I_U;  // nord ouest up
    public final BlockType SO_I_U;  // sud ouest up

    public final BlockType SS;    // sud-sud
    public final BlockType SSE;   // sud-sud est
    public final BlockType SSO;   // sud-sud ouest

    public final BlockType S_D;  // sud down
    public final BlockType SE_D;  // sud est down
    public final BlockType SO_D;  // sud ouest down

    public final BlockType OO;  // ouest ouest
    public final BlockType ONO;  // ouest nord-ouest
    public final BlockType OSO;  // ouest sud-ouest

    public final BlockType EE;  // est est
    public final BlockType ENE;  // est nord-est
    public final BlockType ESE;  // est sud-est

    public SurfaceTypeSetLevel(
            BlockType nu, BlockType su,
            BlockType eu, BlockType ou,
            BlockType neu, BlockType seu,
            BlockType nou, BlockType sou,
            BlockType neiu, BlockType seiu,
            BlockType noiu, BlockType soiu,
            BlockType ss, BlockType sse, BlockType sso,
            BlockType sd, BlockType sed, BlockType sod,
            BlockType oo, BlockType ono, BlockType oso,
            BlockType ee, BlockType ene, BlockType ese
    ){
        this.N_U=nu;
        this.S_U=su;
        this.E_U=eu;
        this.O_U=ou;
        this.NE_U=neu;
        this.SE_U=seu;
        this.NO_U=nou;
        this.SO_U=sou;
        this.NE_I_U=neiu;
        this.SE_I_U=seiu;
        this.NO_I_U=noiu;
        this.SO_I_U=soiu;
        this.SS=ss;
        this.SSE=sse;
        this.SSO=sso;
        this.S_D=sd;
        this.SE_D=sed;
        this.SO_D=sod;
        this.OO = oo;
        this.ONO = ono;
        this.OSO = oso;
        this.EE = ee;
        this.ENE = ene;
        this.ESE = ese;
    }

}
