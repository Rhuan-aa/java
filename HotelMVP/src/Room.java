public class Room {
    private int number;
    private double price;

    public Room(int number, double price) {
        this.number = number > 0 ? number : 1;
        setPrice(price);
    }

    public String asString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Numero Apt.: " + number + '\n').append("Preço: " + price + '\n');

        return builder.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price > 0 ? price : 1.0;
    }
}
