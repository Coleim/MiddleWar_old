/*
 * Middle War - Client
 */

package middlewar.client.exception;

/**
 * Gloal error
 * @author higurashi
 */
public class GameAlreadyStartedException extends Exception{

    public GameAlreadyStartedException(Exception e) {
        super(e.getMessage());
    }

    public GameAlreadyStartedException(String message) {
        super(message);
    }
    
}
