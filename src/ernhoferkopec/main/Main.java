/**
 * 
 */
package ernhoferkopec.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import ernhoferkopec.balancer.Balancer;
import ernhoferkopec.balancer.StartBalancer;
import ernhoferkopec.balancer.WeigtedDistribution;
import ernhoferkopec.server.Server;
import ernhoferkopec.server.StartServer;

/**
 * @author andie
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
        {
            LocateRegistry.createRegistry(1099);
            Balancer balancer = new WeigtedDistribution();
            // Bind this object instance to the name "HelloServer"
            Naming.rebind("balancer", balancer);
            System.out.println("Balancer started");
            
			Server server = new Server("localhost", 7 , "server1");
			System.out.println("IP1: "+server.getIP());
			System.out.println("Register1 "+ server.register());
			//System.out.println("Unregister"+ server.unregister());
			
			Server server2 = new Server("localhost", 4 , "server2");
			System.out.println("IP2: "+server2.getIP());
			System.out.println("Register2 "+ server2.register());
			
			for(int i = 0; i < 100; ++i){
				System.out.println("Durchgang "+i);
				balancer.forwarding(balancer.chooseServer());
			}
			
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		try {
			Thread.sleep(10000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
