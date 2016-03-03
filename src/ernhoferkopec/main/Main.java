/**
 * 
 */
package ernhoferkopec.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import ernhoferkopec.balancer.Balancer;
import ernhoferkopec.balancer.LeastConnection;
import ernhoferkopec.balancer.StartBalancer;
import ernhoferkopec.balancer.WeigtedDistribution;
import ernhoferkopec.client.Client;
import ernhoferkopec.server.Server;
import ernhoferkopec.server.StartServer;

/**
 * @author andie
 *
 */
public class Main {

	private static final String BALANCERIP = "localhost";
	private static final String SERVERIP = "localhost";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
        {
            LocateRegistry.createRegistry(1099);
            Balancer balancer = new WeigtedDistribution(BALANCERIP);
            // Bind this object instance to the name "HelloServer"
            Naming.rebind("balancer", balancer);
            System.out.println("Balancer started");
            
			Server server = new Server(BALANCERIP, SERVERIP, 7 , "server1");
			System.out.println("IP1: "+server.getIP());
			System.out.println("Register1 "+ server.register());
			//System.out.println("Unregister"+ server.unregister());
			
			Server server2 = new Server(BALANCERIP, SERVERIP, 4 , "server2");
			System.out.println("IP2: "+server2.getIP());
			System.out.println("Register2 "+ server2.register());
			
			Client[] clients = new Client[9];
			for(int i = 0; i < clients.length;++i){
				clients[i] = new Client("Client"+(i+1),BALANCERIP);
				clients[i].start();
				clients[i].sendPackages(10);
			}
			//Beenden
			Thread.sleep(1000);
			for(Client client:clients){
				client.end();
			}
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ende");
	}

}
