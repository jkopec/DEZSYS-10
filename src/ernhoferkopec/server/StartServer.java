/**
 * 
 */
package ernhoferkopec.server;

import java.rmi.registry.LocateRegistry;

/**
 * @author andie
 *
 */
public class StartServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
        {
            LocateRegistry.createRegistry(1099);
			Server server = new Server("10.0.105.234", 7 , "server1");
			server.setIP("10.0.104.130");
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
