/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WorldPattern.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.patterns;

import middlewar.server.worldmaker.business.*;
import middlewar.common.*;
import java.io.Serializable;

/**
 * Pattern of world modification (implementations in subclasses)
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class WorldPattern extends Worldable implements Serializable{

    // Size of pattern (used by subclasses)
    protected int x;
    protected int y;

    public WorldPattern(int x,int y,Position position){
        super(position);
        this.x=x;
        this.y=y;
    }
    
}
