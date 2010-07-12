/*
 * Middle War - Client
 */

package middlewar.client.exception;

import java.net.URL;

/**
 * Data connection errors
 * @author hgurashi
 */
public class DataException extends ClientException{

    private URL url = null;

    public DataException(Exception cause) {
        super("Error getting data. \n"+cause.getMessage());
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, URL url) {
        super(message);
        this.url = url;
    }
    
    public DataException(URL url) {
        super("Error getting data.");
        this.url = url;
    }

    public DataException(URL url, Exception cause) {
        this("Error getting data. \n"+cause.getMessage(),url);
    }

    @Override
    public String getMessage() {
        if(url != null) return new String(super.getMessage()+" \n("+this.url.toString()+")");
        else return new String(super.getMessage());
    }

    public String getUrl() {
        if(url != null) return new String("\t|-> "+url.toString());
        else return new String("\t|-> unknown url");
    }

}
