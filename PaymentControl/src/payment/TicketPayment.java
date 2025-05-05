package payment;

import exceptions.InvalidPaymentException;

public class TicketPayment extends BasePayment{


    public TicketPayment(double value, String description) {
        super(value, description);
    }

    @Override
    public void processPayment(double value) throws InvalidPaymentException {
        if (!(value >= 50)) {
            throw new InvalidPaymentException("Erro: Pagamento por boleto deve ser de no mínimo R$ 50.0");
        }
        System.out.println("Pagamento por boleto realizado: R$ " + value);
    }
}
