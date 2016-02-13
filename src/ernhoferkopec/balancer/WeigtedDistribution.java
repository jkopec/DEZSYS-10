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
import ernhoferkopec.server.ServerInt;

/**
 * @author andie
 *
 */
public class WeigtedDistribution extends UnicastRemoteObject implements Balancer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ServerInt> server;
	
	public WeigtedDistribution() throws RemoteException{
		super();
		server = new ArrayList<ServerInt>();
	}

	@Override
	public String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addServer(String ip, String name)  throws RemoteException, MalformedURLException, NotBoundException{
		ServerInt server = (ServerInt) Naming.lookup( "//" + ip + "/"+ name);
		this.server.add(server);
		return true;
	}

	@Override
	public boolean removeServer(String ip, String name)  throws RemoteException, MalformedURLException, NotBoundException{
		ServerInt server = (ServerInt) Naming.lookup( "//" + ip + "/"+ name);
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
