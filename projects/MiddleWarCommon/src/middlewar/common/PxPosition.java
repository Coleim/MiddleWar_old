/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

/**
 * @see Position
 * @author higurashi
 */
public class PxPosition extends Position{

    public static final PxPosition origin = new PxPosition(0, 0);

    public PxPosition(int x, int y) {
        super(x, y);
    }

}
