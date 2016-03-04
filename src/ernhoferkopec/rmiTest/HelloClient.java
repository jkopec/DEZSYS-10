package ernhoferkopec.rmiTest;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient
{
    public static void main(String arg[])
    {
        String message = "blank";

        // I download server's stubs ==> must set a SecurityManager
        //System.setSecurityManager(new RMISecurityManager());

        System.setProperty("java.rmi.server.hostname","10.0.104.107");

        try
        {

            System.out.println("Starten des RMI Clients");

            Hello obj = (Hello) Naming.lookup( "//" +
                    "10.0.104.130" +
                    "/HelloServer");         //objectname in registry
            
            System.out.println("vorher");
            //Registry r = LocateRegistry.getRegistry("10.0.105.234");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("hitler", obj);
            System.out.println("nachher");
            System.out.println(obj.sayHello());
        }
        catch (Exception e)
        {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}