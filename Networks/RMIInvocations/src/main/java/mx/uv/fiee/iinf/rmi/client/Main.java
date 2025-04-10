package mx.uv.fiee.iinf.rmi.client;

import mx.uv.fiee.iinf.rmi.server.services.Calculus;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * The Main class is the client application that invokes remote methods
 * on the Calculus service.
 */
public class Main {

    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 9999;
    private final String SERVICE_NAME = "calculusService";

    /**
     * Invokes the remote method to calculate payment.
     */
    public void invokeRemoteMethod () {
        try {
            Registry registry = LocateRegistry.getRegistry (SERVER_HOST, SERVER_PORT);
            Calculus implementation = (Calculus) registry.lookup (SERVICE_NAME);

            double calculatePayment = implementation.calculatePayment (1000, 0.16);
            System.out.println ("El resultado es: " + calculatePayment);
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * The main method to start the client application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Main().invokeRemoteMethod();
    }

}
