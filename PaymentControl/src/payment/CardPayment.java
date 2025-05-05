package payment;

import exceptions.InvalidPaymentException;

public class CardPayment extends BasePayment{

    public CardPayment(double value, String description) {
        super(value, description);
    }

    @Override
    public void processPayment(double value) throws InvalidPaymentException {

        if (value > 1000 || value < 0) {
            throw new InvalidPaymentException("Erro: Pagamento por boleto deve ser de no máximo R$ 1000.0 " +
                    "e no mínimo R$ 0.1");
        }
        System.out.println("Pagamento com cartão realizado: R$ " + value);
    }
}
