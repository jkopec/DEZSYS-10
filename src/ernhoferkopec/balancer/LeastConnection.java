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

import ernhoferkopec.server.ServerInt;

/**
 * @author andie
 *
 */
public class LeastConnection extends UnicastRemoteObject implements Balancer{

	private static final long serialVersionUID = 1L;
	private ArrayList<ServerInt> server;

	public LeastConnection() throws RemoteException {
		super();
		server = new ArrayList<ServerInt>();
	}

	/**
	 * 
	 */

	@Override
	public boolean addServer(String ip, String name)  throws RemoteException, MalformedURLException, NotBoundException{
		System.out.println("Server adden name: "+name);
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
	public ServerInt chooseServer() throws RemoteException {
		ServerInt s = this.server.get(0);
		for(int i = 1; i<this.server.size();++i){
			if(this.server.get(i).getConnections()<s.getConnections()){
				s= this.server.get(i);
			}
		}
		return s;
	}

	@Override
	public boolean forwarding(ServerInt server) {
		Runnable ra = new Runnable(){
			@Override
			public void run() {
				try {
					server.doSomething();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(ra);
		t.start();
		return false;
	}

	@Override
	public boolean execute() throws RemoteException {
		ServerInt server = chooseServer();
		Runnable ra = new Runnable(){
			@Override
			public void run() {
				try {
					server.doSomething();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(ra);
		t.start();
		return false;
	}

	@Override
	public String getIP() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
