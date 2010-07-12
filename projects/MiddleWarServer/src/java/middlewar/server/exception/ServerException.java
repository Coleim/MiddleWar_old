/*
 * Middle War - Server
 * 
 */

package middlewar.server.exception;

/**
 * Gloal error
 * @author higurashi
 */
public class ServerException extends Exception{

    public ServerException(Exception e) {
        super(e.getMessage());
    }

    public ServerException(String message) {
        super(message);
    }
    
}
