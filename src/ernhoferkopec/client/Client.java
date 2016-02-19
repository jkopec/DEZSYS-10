package ernhoferkopec.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ernhoferkopec.balancer.Balancer;

public class Client extends Thread{
	
	private Balancer balancer;
	private String name;
	private boolean running;
	
	public Client(String name, String balancerIP) throws MalformedURLException, RemoteException, NotBoundException{
		this.name = name;
		this.balancer = (Balancer) Naming.lookup( "//" +
                balancerIP +
                "/balancer");
		this.running = true;
	}
	
	@Override
	public void run(){
		while(running){
			
		}
	}
	
}
