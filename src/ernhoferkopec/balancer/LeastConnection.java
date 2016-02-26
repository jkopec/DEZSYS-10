/**
 * 
 */
package ernhoferkopec.balancer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ernhoferkopec.server.ServerInt;

/**
 * @author andie
 *
 */
public class LeastConnection extends UnicastRemoteObject implements Balancer{

	private static final long serialVersionUID = 1L;
	private ArrayList<ServerInt> server;

	protected LeastConnection() throws RemoteException {
		super();
		server = new ArrayList<ServerInt>();
	}

	/**
	 * 
	 */

	@Override
	public String getIP() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addServer(String ip, String name) throws RemoteException,
			MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeServer(String ip, String name) throws RemoteException,
			MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ServerInt chooseServer() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean forwarding(ServerInt server) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
