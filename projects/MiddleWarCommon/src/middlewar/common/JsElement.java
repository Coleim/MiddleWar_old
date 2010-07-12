/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;


import java.io.IOException;
import java.io.Writer;

/**
 * Elément qui peut être représenté par du code HTML
 * @author higurashi
 */
public interface  JsElement {

    public abstract void printJs(Writer out) throws IOException;

}
