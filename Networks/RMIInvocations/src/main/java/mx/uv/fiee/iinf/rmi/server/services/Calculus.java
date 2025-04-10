package mx.uv.fiee.iinf.rmi.server.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines a remote method for calculating payment.
 * It extends the Remote interface to allow remote method invocation.
 */
public interface Calculus extends Remote {

    /**
     * Calculates the payment after applying tax.
     * @param amount The initial amount.
     * @param tax The tax rate to be applied.
     * @return The calculated payment after tax.
     * @throws RemoteException If a remote communication error occurs.
     */
    double calculatePayment (double amount, double tax) throws RemoteException;

}
