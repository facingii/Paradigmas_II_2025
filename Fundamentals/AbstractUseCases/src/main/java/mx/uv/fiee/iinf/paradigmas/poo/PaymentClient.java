package mx.uv.fiee.iinf.paradigmas.poo;

abstract class PaymentMethod {
    String cardNumber;
    String cardHolder;
    abstract void processPayment ();
    abstract boolean validate ();
    abstract void refund ();
}

public class PaymentClient {

    public static void main (String [] args) {

    }

}

class CreditCard extends PaymentMethod {
    @Override
    void processPayment () {}

    @Override
    boolean validate () {
        return false;
    }

    @Override
    void refund () {}
}