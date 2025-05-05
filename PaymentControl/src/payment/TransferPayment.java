package payment;

import exceptions.InvalidPaymentException;

public class TransferPayment extends BasePayment{

    public TransferPayment(double value, String description) {
        super(value, description);
    }

    @Override
    public void processPayment(double value) throws InvalidPaymentException {
        if (!(value < 5000) || !(value >= 100)) {
            throw new InvalidPaymentException("Erro: Valor inválido para transferência: deve estar entre R$ 100.0 " +
                    "e R$ 5000.0");
        }
        System.out.println("Pagamento por transferência realizado: R$ " + value);
    }
}
