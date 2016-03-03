package ernhoferkopec.rmiTest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello
{
	public HelloImpl() throws RemoteException { super(); }

	public String sayHello() { 
		System.out.println("drin");
		Hello obj;
		try {
			obj = (Hello) Naming.lookup( "//" +
			        "10.0.105.234" +
			        "/asd");
	        System.out.println(obj.s());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello world!"; 
	}
	
	public String s(){
		return "muh";
	}

	public static void main(String args[])
	{
		try
		{
			LocateRegistry.createRegistry(1099);
			System.setProperty( "java.rmi.server.hostname", "10.0.105.234" );
			HelloImpl obj = new HelloImpl();
			// Bind this object instance to the name "HelloServer"
			Naming.rebind("HelloServer", obj);
			System.out.print("RMI Server laeuft");
		}
		catch (Exception e)
		{
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}
} //rmirgistry in production/dezss08