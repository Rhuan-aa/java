package conversor;

/*
* Crie uma classe ConversorMoeda que implementa uma interface ConversaoFinanceira com o
* método converterDolarParaReal() para converter um valor em dólar para reais.
*  A classe deve receber o valor em dólar como parâmetro.
* */

public class CurrencyConverter implements FinancialConverter{
    public double real, price;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getReal() {
        return real;
    }

    @Override
    public void convertDollarToReal(double dollar) {
        real = dollar * price;
    }
}
