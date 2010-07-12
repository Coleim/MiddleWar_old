/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.WorldMakerSerializer.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import java.io.*;
import middlewar.server.exception.ServerException;

/**
 * Save and Load Worlds / Maps
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WorldMakerSerializer {

    public static String save(Map map,String file) {
		
        try {
			//if(Constains.debugWorldCreation) System.out.print("[ws] saving world in '"+file+"' : ");
			FileOutputStream fos = new FileOutputStream(file);

			ObjectOutputStream oos= new ObjectOutputStream(fos);

            try {
				oos.writeObject(map);
				oos.flush();
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}

		} catch(IOException e) {
            //if(Constains.debugWorldCreation) System.out.println("error : "+e.getMessage());
		}
        //if(Constains.debugWorldCreation) System.out.println("done");
        return file;
	}


    public static String save(World world,String file) {

        try {
			//if(Constains.debugWorldCreation) System.out.print("[ws] saving meta world in '"+file+"' : ");
			FileOutputStream fos = new FileOutputStream(file);

			ObjectOutputStream oos= new ObjectOutputStream(fos);

            try {
				oos.writeObject(world);
				oos.flush();
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}

		} catch(IOException e) {
            //if(Constains.debugWorldCreation) System.out.println("error : "+e.getMessage());
		}
        //if(Constains.debugWorldCreation) System.out.println("done");
        return file;
	}


    public static Map loadMap(String file) throws ServerException {
		Map w = null;
		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {
				w = (Map) ois.readObject();
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			throw new ServerException(ioe);
		} catch(ClassNotFoundException cnfe) {
			throw new ServerException(cnfe);
		}
        return w;
	}

    public static World loadWorld(String file) throws ServerException {
		World w = null;
		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {
				w = (World) ois.readObject();
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			throw new ServerException(ioe);
		} catch(ClassNotFoundException cnfe) {
			throw new ServerException(cnfe);
		}
        return w;
	}
}
