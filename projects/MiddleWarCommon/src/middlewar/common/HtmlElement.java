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
public interface HtmlElement {

    public abstract void printHtml(Writer out) throws IOException;

}
