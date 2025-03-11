package bookstore;

public class PhysicalProduct implements Calculable {
    double tax, discount, price;

    public PhysicalProduct(double tax, double discount, double price) {
        this.tax = tax;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public double calculateFinalPrice() {
        return (price + tax) * (1 - discount);
    }
}
