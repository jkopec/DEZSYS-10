/**
 * 
 */
package ernhoferkopec.balancer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

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
            Balancer balancer = new WeigtedDistribution();
            // Bind this object instance to the name "HelloServer"
            Naming.rebind("balancer", balancer);
            System.out.print("Balancer started");
        }
        catch (Exception e)
        {
            System.out.println("TOT err: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
