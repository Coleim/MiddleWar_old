/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.SurfaceTypeSetExtended.java
 *
 * History :
 * 1.1     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

/**
 * Set of images, describing a surface (extended set, minis)
 * @author Higurashi
 * @version WM 1.1
 * @since WM 1.1
 */
public class SurfaceTypeSetExtended extends SurfaceTypeSet{

    public final BlockType N_M;  // nord mini
    public final BlockType S_M;  // sud mini
    public final BlockType E_M;  // est mini
    public final BlockType O_M;  // ouest mini
    public final BlockType V_M;  // vertical mini
    public final BlockType H_M;  // horizontal mini
    public final BlockType C_M;  // centre mini
    public final BlockType HV_M;  // horizontal-vertical mini
    public final BlockType NE_M;  // nord est mini
    public final BlockType SE_M;  // sud est mini
    public final BlockType NO_M;  // nord ouest mini
    public final BlockType SO_M;  // sud ouest mini

    public final BlockType NE_H_M;
    public final BlockType NO_H_M;
    public final BlockType SE_H_M;
    public final BlockType SO_H_M;

    public final BlockType NE_V_M;
    public final BlockType NO_V_M;
    public final BlockType SE_V_M;
    public final BlockType SO_V_M;

    public final BlockType E_V_M;
    public final BlockType O_V_M;
    public final BlockType N_H_M;
    public final BlockType S_H_M;

    public SurfaceTypeSetExtended(
            BlockType nm, BlockType sm,
            BlockType em, BlockType om,
            BlockType vm, BlockType hm,BlockType cm ,
            BlockType hvm,
            BlockType nem, BlockType sem,
            BlockType nom, BlockType som,
            BlockType nehm, BlockType sehm, BlockType nohm, BlockType sohm,
            BlockType nevm, BlockType sevm, BlockType novm, BlockType sovm,
            BlockType evm, BlockType ovm, BlockType nhm, BlockType shm
    ){
        this.N_M=nm;
        this.S_M=sm;
        this.E_M=em;
        this.O_M=om;
        this.V_M=vm;
        this.H_M=hm;
        this.HV_M=hvm;
        this.C_M=cm;
        this.NE_M=nem;
        this.SE_M=sem;
        this.NO_M=nom;
        this.SO_M=som;
        this.NE_H_M=nehm;
        this.SE_H_M=sehm;
        this.NO_H_M=nohm;
        this.SO_H_M=sohm;
        this.NE_V_M=nevm;
        this.SE_V_M=sevm;
        this.NO_V_M=novm;
        this.SO_V_M=sovm;
        this.E_V_M=evm;
        this.O_V_M=ovm;
        this.N_H_M=nhm;
        this.S_H_M=shm;
    }

}
