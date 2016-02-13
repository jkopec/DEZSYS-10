/**
 * 
 */
package ernhoferkopec.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author andie
 *
 */
public interface ServerInt extends Remote{
	public boolean register() throws RemoteException;
	public boolean unregister() throws RemoteException;
	public int getWeight() throws RemoteException;
	public int getConnections() throws RemoteException;
	public String getIP() throws RemoteException;
}
