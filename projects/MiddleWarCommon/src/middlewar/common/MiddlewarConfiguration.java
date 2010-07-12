/*
 * Middle War - Common
 *
 */

package middlewar.common;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.StringWriter;
//import java.util.StringTokenizer;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * Manage configuration of middlewar
 * (read file in /etc/mw.conf)
 * @author higurashi
 */
public class MiddlewarConfiguration {

    private static String imageDistPath="http://middlewar.dev/middlewar/images/";
    private static String clientDistPath="http://middlewar.dev/middlewar/MiddleWarClient.jar";
    private static String commonDistPath="http://middlewar.dev/middlewar/MiddleWarCommon.jar";
    private static String xmwpDistPath="http://middlewar.dev/middlewar/MiddleWarXMWP.jar";
    private static String xmwpSrvUrl="http://middlewar.dev:8080/MiddleWarServer/MiddleWarXMWPServer";

    //private static final String confFile="/mw.conf";

    /**
     * Read the configuration file
     */
    /*
    private static void readConfiguration() throws Exception{
        try{
            InputStream ips=new FileInputStream(confFile);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            while ((line=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line,"=");
                if(st.countTokens() == 2){
                    String opt = st.nextToken();
                    String value = st.nextToken();
                    if(opt.equals("image-dist")) imageDistPath=new String(value);
                    if(opt.equals("client-dist")) clientDistPath=new String(value);
                    if(opt.equals("common-dist")) commonDistPath=new String(value);
                    if(opt.equals("xmwp-dist")) xmwpDistPath=new String(value);
                    if(opt.equals("xmwp-server")) xmwpSrvUrl=new String(value);
                }
            }
            br.close();
        }
        catch (Exception e){
            throw e;
        }
    }
    */
    /**
     * Return the http:// path for images
     * @return the url
     */
    public static String getImageDistPath(){
        if(imageDistPath==null) try {
            //readConfiguration();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return imageDistPath;
    }

    /**
     * Return the http:// path for client jar
     * @return the url
     */
    public static String getClientDistPath(){
        if(clientDistPath==null) try {
            //readConfiguration();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return clientDistPath;
    }

    /**
     * Return the http:// path for common jar
     * @return the url
     */
    public static String getCommonDistPath(){
        if(commonDistPath==null) try {
            //readConfiguration();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return commonDistPath;
    }

    /**
     * Return the http:// path for xmwp jar
     * @return the url
     */
    public static String getXMWPDistPath(){
        if(xmwpDistPath==null) try {
            //readConfiguration();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return xmwpDistPath;
    }

    /**
     * Return the http:// path for xmwp servlet
     * @return the url
     */
    public static String getXMWPSrvUrl(){
        if(xmwpSrvUrl==null) try {
            //readConfiguration();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return xmwpSrvUrl;
    }


}
