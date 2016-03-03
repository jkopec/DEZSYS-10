/**
 * 
 */
package ernhoferkopec.balancer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author andie
 *
 */
public class StartBalancer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
        {
            LocateRegistry.createRegistry(1099);
            System.setProperty( "java.rmi.server.hostname", "10.0.105.234" );
            Balancer balancer = new WeigtedDistribution();
            balancer.setIP("10.0.105.234");
            // Bind this object instance to the name "HelloServer"
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("balancer", balancer);
            //Naming.rebind("balancer", balancer);
            System.out.println("Balancer started");
        }
        catch (Exception e)
        {
            System.out.println("TOT err: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
