/**
 * 
 */
package ernhoferkopec.balancer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ernhoferkopec.server.Server;

/**
 * @author andie
 *
 */
public interface Balancer extends Remote {
	public String getIP() throws RemoteException;
	public boolean addServer(String ip, String name) throws RemoteException, MalformedURLException, NotBoundException;
	public boolean removeServer(String ip, String name) throws RemoteException, MalformedURLException, NotBoundException;
	public Server chooseServer() throws RemoteException;
	public boolean forwarding(Server server) throws RemoteException;
}
