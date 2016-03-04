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

	private static final String BALANCERIP = "10.0.106.5";
	private static final String SERVERIP = "10.0.106.5";
	private static final int ANZAHL = 1;
	private static final int[] weight = {7};

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
				servers[i] = new Server(BALANCERIP,SERVERIP, weight[i] , "server"+(i+6));
				servers[i].register();
			}
			System.out.println("Server erzeugt");
        }
        catch (Exception e)
        {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
