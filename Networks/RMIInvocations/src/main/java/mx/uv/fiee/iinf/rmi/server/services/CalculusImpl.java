package mx.uv.fiee.iinf.rmi.server.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * The CalculusImpl class implements the Calculus interface and provides
 * the actual implementation of the remote method.
 */
public class CalculusImpl extends UnicastRemoteObject implements Calculus {

    /**
     * Constructs a new CalculusImpl object and exports it.
     * @throws RemoteException If a remote communication error occurs.
     */
    public CalculusImpl () throws RemoteException {

    }

    /**
     * Calculates the payment after applying tax.
     * @param amount The initial amount.
     * @param tax The tax rate to be applied.
     * @return The calculated payment after tax.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public double calculatePayment(double amount, double tax) throws RemoteException {
        return amount - (amount * tax);
    }

}
