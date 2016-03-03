/**
 * 
 */
package ernhoferkopec.balancer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ernhoferkopec.server.Server;
import ernhoferkopec.server.ServerInt;

/**
 * @author andie
 *
 */
public interface Balancer extends Remote {
	public String getIP() throws RemoteException;
	public void setIP(String ip);
	public boolean addServer(String ip, String name) throws RemoteException, MalformedURLException, NotBoundException;
	public boolean removeServer(String ip, String name) throws RemoteException, MalformedURLException, NotBoundException;
	public ServerInt chooseServer() throws RemoteException;
	public boolean forwarding(ServerInt server) throws RemoteException;
	public boolean execute() throws RemoteException;
	public boolean execute(String ip) throws RemoteException;
}
