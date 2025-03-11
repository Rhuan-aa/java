package bookstore;

public class Book implements Calculable{
    double tax, discount, price;

    public Book(double tax, double discount, double price) {
        this.tax = tax;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public double calculateFinalPrice() {
        return (price + tax) * (1 - discount);
    }
}
