/**
 * 
 */
package ernhoferkopec.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author andie
 *
 */
public class StartClient {

	private static final String BALANCERIP = "10.0.104.130";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            //LocateRegistry.createRegistry(1099);
            //System.setProperty( "java.rmi.server.hostname", "10.0.105.234" );
			Client client1 = new Client("Client1",BALANCERIP);
			//client1.setIp(BALANCERIP);
			client1.start();
			client1.sendPackages(100);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
