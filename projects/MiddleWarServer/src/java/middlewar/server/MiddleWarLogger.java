/*
 * Middle War - Server
 *
 */

package middlewar.server;

import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.WorldMakerException;
import middlewar.xmwp.XMWPException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Manage the logs for the MW server
 * @author higurashi
 */
public class MiddleWarLogger {

    // log4j logger
    private Logger logger = null;

    // prefixs
    public static final String PREFIX_XMWP = "[XMWP]";
    public static final String PREFIX_WM = "[WrldMkr]";

    public MiddleWarLogger() {
        if(logger==null){
            logger = Logger.getLogger("MWServerLogger");
            PropertyConfigurator.configure("log4j.properties");
            logger.info("===== SERVER START =====");
        }
    }

    /**
     * Return the log4j logger
     * @return the logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Log an important info
     * @param message the info
     */
    public void logMainInfo(String message) {
        logger.info(">>> "+message);
    }

    /**
     * Log an error linked with XMWP
     * @param message the error message
     * @param e the source of the error
     */
    private void logXMWPError(String message,Throwable e){
        logger.error(PREFIX_XMWP+" "+message, e);
    }

    /**
     * Log an info linked with XMWP
     * @param message the info message
     */
    public void logXMWPInfo(String message){
        logger.info(PREFIX_XMWP+" "+message);
    }

    /**
     * Log an error linked with WorldMaker
     * @param message the error message
     * @param e the source of the error
     */
    private void logWMError(String message,Throwable e){
        logger.error(PREFIX_WM+" "+message, e);
    }

    /**
     * Log an info linked with WorldMaker
     * @param message the info message
     */
    public void logWMInfo(String message){
        logger.info(PREFIX_WM+" "+message);
    }

    /**
     * Log an info
     * @param message the info message
     */
    public void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Log an error
     * @param message the error message
     * @param e the source of the error
     */
    private void logError(String message, Throwable e) {
        logger.error(message,e);
    }

    /**
     * @see logError
     */
    public void logError(XMWPException e) {
        this.logXMWPError(e.getMessage(), e);
    }

    /**
     * @see logError
     */
    public void logError(ServerException e) {
        this.logError(e.getMessage(), e);
    }

    /**
     * @see logError
     */
    public void logError(WorldMakerException e) {
        this.logWMError(e.getMessage(), e);
    }

    /**
     * @see logError
     * @param location an info for the location of the error
     */
    public void logError(XMWPException e,String location) {
        this.logXMWPError(e.getMessage()+"@"+location, e);
    }

    /**
     * @see logError
     * @param location an info for the location of the error
     */
    public void logError(ServerException e,String location) {
        this.logError(e.getMessage()+"@"+location, e);
    }

    /**
     * Log a global error (unknown)
     * @param e the error
     */
    public void logError(Exception e) {
        this.logError(e.getClass().getName()+"::"+e.getMessage(), e);
    }

    /**
     * Log a debug message
     * @param message the debug message
     */
    void logDebug(String message) {
        //this.logger.debug(message);
    }

}