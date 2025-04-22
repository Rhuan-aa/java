public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[150];
        int index = 0;

        for (int i = 1; i <= 50; i++){
            figures[index++] = new Triangle(i,i,i,i,i);
            figures[index++] = new Rectangle(i,i,i,i);
            figures[index++] = new Circle(i,i,i);
        }

        System.out.printf("%.2f", Calculator.calculateTotalArea(figures));
    }
}