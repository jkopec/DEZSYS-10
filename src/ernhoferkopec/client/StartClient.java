/**
 * 
 */
package ernhoferkopec.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author andie
 *
 */
public class StartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            System.setProperty( "java.rmi.server.hostname", "10.0.105.234" );
			Client client1 = new Client("Client1","10.0.105.234");
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
