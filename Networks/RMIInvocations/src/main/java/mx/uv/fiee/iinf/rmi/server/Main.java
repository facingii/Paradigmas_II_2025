package mx.uv.fiee.iinf.rmi.server;

import mx.uv.fiee.iinf.rmi.server.services.CalculusImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * The Main class is the server application that registers the Calculus service
 * and waits for client connections.
 */
public class Main {
    private final int PORT = 9999;
    private final String SERVICE_NAME = "calculusService";

    /**
     * Starts the RMI server and registers the Calculus service.
     */
    private void startServer () {
        try {
            Registry registry = LocateRegistry.createRegistry (PORT);
            registry.rebind (SERVICE_NAME, new CalculusImpl ());

            System.out.println ("Server started and waiting for clients...");
            Thread.currentThread().join();
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * The main method to start the server application.
     * @param args Command line arguments.
     */
    public static void main(String [] args) {
        new Main ().startServer ();
    }

}
