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

	private static final String BALANCERIP = "10.0.105.234";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
        {
            LocateRegistry.createRegistry(1099);
            System.setProperty( "java.rmi.server.hostname", BALANCERIP );
            Balancer balancer = new LeastConnection(BALANCERIP);
            //balancer.setIP(BALANCERIP);
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
