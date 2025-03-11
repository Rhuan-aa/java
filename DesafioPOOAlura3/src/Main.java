import bookstore.Book;
import bookstore.PhysicalProduct;
import calculator.RectangularRoomCalculator;
import conversor.CurrencyConverter;
import multiplicationtable.MultiplicationTable;
import temperature.StandardTemperatureConversor;

public class Main {
    public static void main(String[] args) {

        //Ex 01
        CurrencyConverter converter = new CurrencyConverter();
        converter.setPrice(5.81);
        converter.convertDollarToReal(25.00);
        System.out.println(converter.getReal());

        //Ex 02
        RectangularRoomCalculator room = new RectangularRoomCalculator(120,35);
        System.out.println(room.calculateArea() + "m2");
        System.out.println(room.calculatePerimeter() + "m");

        //Ex 03
        MultiplicationTable table = new MultiplicationTable();
        table.showMultiplicationTable(9);

        //Ex 04
        StandardTemperatureConversor conversor = new StandardTemperatureConversor();
        System.out.println(conversor.celciusToFahrenheit(34.00));
        System.out.println(conversor.fahrenheitToCelcius(34.00));

        //Ex 05
        Book book = new Book(5.55,0.35,125);
        System.out.printf("%.2f\n", book.calculateFinalPrice());

        PhysicalProduct product = new PhysicalProduct(3.55, 0.25, 75);
        System.out.printf("%.2f\n", product.calculateFinalPrice());

    }
}