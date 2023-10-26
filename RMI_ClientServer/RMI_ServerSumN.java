package RMI_ClientServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_ServerSumN extends UnicastRemoteObject implements RMI_InterfaceSumN {
    public RMI_ServerSumN() throws RemoteException {
        super();
    }

    @Override
    public double sumUptoN(double n) throws RemoteException {
        double sum = (n * (n + 1)) / 2;
        System.out.println("Sum of numbers up to " + n + " is: " + sum);    
        return sum;
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(8888);
            registry.bind("sumn", new RMI_ServerSumN());
            System.out.println("The RMI Sum App is running and ready...");
        } catch (Exception e) {
            System.out.println("Error: The RMI Sum App is not running...");
        }
    }
}
