package payment;

import exceptions.InvalidPaymentException;

public interface Payment {
    void processPayment(double value) throws InvalidPaymentException;
}
