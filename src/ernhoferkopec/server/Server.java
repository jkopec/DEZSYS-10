package ernhoferkopec.server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;

import ernhoferkopec.balancer.Balancer;

public class Server extends UnicastRemoteObject implements ServerInt{
	
	private int weight;
	private int connections;
	private String balancerIP, name;
	private Balancer balancer;
	private static final long serialVersionUID = 1L;
	
	public Server(String balancerIP, int weight, String name) throws MalformedURLException, RemoteException, NotBoundException{
		this.balancerIP = balancerIP;
		this.weight = weight;
		this.name = name;
		this.balancer = (Balancer) Naming.lookup( "//" +
                this.balancerIP +
                "/balancer");
	}
	
	public boolean register(){
		try {
			Naming.rebind(name, this);
			this.balancer.addServer(this.getIP(), name);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		} catch (MalformedURLException | NotBoundException e) {
			System.out.println("Fehler beim rebind");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean unregister(){
		try {
			this.balancer.removeServer(this.getIP(), name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public int getWeight() {
		return weight;
	}

	public int getConnections() {
		return connections;
	}
	
	public String getIP(){
		InetAddress IP;
		try {
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements()){
				NetworkInterface i = e.nextElement();
				//System.out.println(i.getName()+": "+i.toString());
			}
			
			IP = InetAddress.getLocalHost();
			//return ""+IP.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			//return null;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
		return "localhost";
	}
	
}
