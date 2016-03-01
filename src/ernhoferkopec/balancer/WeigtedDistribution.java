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
import java.util.Collections;
import java.util.Comparator;

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
		System.out.println("Server adden name: "+name);
		ServerInt server = (ServerInt) Naming.lookup( "//" + ip + "/"+ name);
		for(int i = 0; i < this.server.size();++i){
			if(server.getWeight()<=this.server.get(i).getWeight()){
				this.server.add(i,server);
				return true;
			}
		}
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
		while(true){
			for(int i = 0; i<this.server.size()-1;++i){
				if(this.server.get(i).getWeight()>this.server.get(i+1).getWeight()){
					//System.out.println(this.server.get(i).getWeight());
					return this.server.get(i);
				}
			}
			if(this.server.get(this.server.size()-1).getWeight()>=1){
				//System.out.println(this.server.get(this.server.size()-1).getWeight());
				return this.server.get(this.server.size()-1);
			}
		}
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
}
