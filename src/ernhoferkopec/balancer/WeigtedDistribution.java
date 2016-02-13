/**
 * 
 */
package ernhoferkopec.balancer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ernhoferkopec.server.Server;

/**
 * @author andie
 *
 */
public class WeigtedDistribution extends UnicastRemoteObject implements Balancer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Server> server;
	
	public WeigtedDistribution() throws RemoteException{
		super();
		server = new ArrayList<Server>();
	}

	@Override
	public String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addServer(String ip, String name)  throws RemoteException, MalformedURLException, NotBoundException{
		Server server = (Server) Naming.lookup( "//" + ip + name);
		this.server.add(server);
		return true;
	}

	@Override
	public boolean removeServer(Server server)  throws RemoteException{
		this.server.remove(server);
		return true;
	}

	@Override
	public Server chooseServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean forwarding(Server server) {
		// TODO Auto-generated method stub
		return false;
	}
}
