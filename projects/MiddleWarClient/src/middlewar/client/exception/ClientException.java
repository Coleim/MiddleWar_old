/*
 * Middle War - Client
 */

package middlewar.client.exception;

/**
 * Gloal error
 * @author higurashi
 */
public class ClientException extends Exception{

    public ClientException(Exception e) {
        super(e.getMessage());
    }

    public ClientException(String message) {
        super(message);
    }
    
}
