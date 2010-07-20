/*
 * Middle War - Server
 *
 */

package middlewar.server.jsp;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.http.HttpServletRequest;
import middlewar.common.HtmlElement;
import middlewar.common.JsElement;
import middlewar.server.exception.ServerException;

/**
 * Part of a jsp page
 * @author Higurashi
 */
public abstract class JspElement implements HtmlElement,JsElement {

    protected HttpServletRequest request;
    protected String playerId;
    protected String playerKey;
    protected String jsCallOnClick;

    public JspElement(HttpServletRequest request,String playerId, String playerKey) {
        this.playerId = playerId;
        this.request = request;
        this.playerKey = playerKey;
        this.jsCallOnClick = "";
    }

    @Override
    public void printHtml(Writer out) throws IOException {
        try{
            printJspHtml(out);
        }catch(ServerException e){
            out.write(e.getMessage());
        }
    }

    @Override
    public void printJs(Writer out) throws IOException{
        try{
            printJspJs(out);
        }catch(ServerException e){
            out.write(e.getMessage());
        }
    }

    protected void printJspJs(Writer out) throws IOException, ServerException {}
    
    protected abstract void printJspHtml(Writer out) throws IOException, ServerException;

    public void setJsCallOnClick(String js){ this.jsCallOnClick=js; }
    
}
