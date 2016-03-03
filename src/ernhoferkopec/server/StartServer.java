/**
 * 
 */
package ernhoferkopec.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author andie
 *
 */
public class StartServer {

	private static final String BALANCERIP = "10.0.105.234";
	private static final String SERVERIP = "10.0.105.234";
	private static final int ANZAHL = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e1) {
		}
		try
        {
			Server[] servers = new Server[ANZAHL];
			for(int i = 0; i < servers.length;++i){
				servers[i] = new Server(BALANCERIP,SERVERIP, 7 , "server"+(i+1));
				servers[i].register();
			}
        }
        catch (Exception e)
        {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
