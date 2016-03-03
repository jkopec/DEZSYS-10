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
	private int packages;

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
			if(packages>0){
				try {
					this.balancer.execute(name);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				--packages;
			}
		}
	}

	public void sendPackages(int amount){
		this.packages += amount;
	}
	
	public void end(){
		this.running = false;
	}
}
