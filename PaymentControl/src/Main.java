import exceptions.InvalidPaymentException;
import payment.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Payment payment1 = new TicketPayment(30.0, "Boleto - Conta de água");
        Payment payment2 = new CardPayment(800.0, "Cartão - Compra na loja XYZ");
        Payment payment3 = new TransferPayment(7000.0, "Transferência - Fornecedor ABC");
        Payment payment4 = new TicketPayment(60.0, "Boleto - Internet");
        Payment payment5 = new CardPayment(1200.0, "Cartão - Eletrônicos");
        Payment payment6 = new TransferPayment(450.0, "Transferência - Aluguel");

        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(payment1);
        paymentList.add(payment2);
        paymentList.add(payment3);
        paymentList.add(payment4);
        paymentList.add(payment5);
        paymentList.add(payment6);

        for (Payment p : paymentList){
            BasePayment payment = (BasePayment) p;
            System.out.println("\nProcessando: " + payment.getDescription());

            try {
                p.processPayment(payment.getValue());
            } catch (InvalidPaymentException e) {
                System.out.println("Erro: "+ e.getMessage());
            }
        }
    }
}