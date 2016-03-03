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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		try
        {
			Server server = new Server(BALANCERIP,SERVERIP, 7 , "server1");
			//server.setIP(SERVERIP);
			System.out.println("IP1: "+server.getIP());
			System.out.println("Register1 "+ server.register());
			//System.out.println("Unregister"+ server.unregister());
        }
        catch (Exception e)
        {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
