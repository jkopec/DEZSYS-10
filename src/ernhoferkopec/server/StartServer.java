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
			Server server = new Server("localhost", 7 , "server1");
			System.out.println("IP: "+server.getIP());
			System.out.println(server.register());
        }
        catch (Exception e)
        {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
