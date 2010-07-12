/*
 * MiddleWar - Common (client & server)
 *
 */

package middlewar.common;

import java.io.IOException;
import java.io.Writer;

/**
 * Elément qui peut être représenté par du code HTML et JS
 * @author higurashi
 */
public abstract class HtmlComplexlElement implements HtmlElement,JsElement{

    public abstract void printHtml(Writer out) throws IOException;

    public abstract void printJs(Writer out) throws IOException;

    public abstract void print(Writer outJs,Writer outHtml ) throws IOException;

}
