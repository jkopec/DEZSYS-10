/**
 * 
 */
package ernhoferkopec.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import ernhoferkopec.server.Server;

/**
 * @author andie
 *
 */
public class StartClient {

	private static final String BALANCERIP = "10.0.106.5";
	private static final int ANZAHL = 9;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client[] clients = new Client[ANZAHL];
			for(int i = 0; i < clients.length;++i){
				clients[i] = new Client("Client"+(i+1),BALANCERIP);
				clients[i].start();
				clients[i].sendPackages(10);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
