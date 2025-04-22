public class Calculator {


    private Calculator() {}

    public static double calculateTotalArea(Figure[] figures) {
        double totalArea = 0.00;
        for (Figure figure : figures){
            totalArea += figure.area();
        }

        return totalArea;
    }
}
