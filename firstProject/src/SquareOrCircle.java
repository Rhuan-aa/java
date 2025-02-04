import java.util.Scanner;
import java.lang.Math;

public class SquareOrCircle {
    public static void main(String[] args) {
        String menu;
        menu = """
                1 - Calcular Area de um Quadrado
                2 - Calcular Area de um Círculo
                """;
        System.out.println(menu);
        Scanner scanOpt = new Scanner(System.in);
        int opt = scanOpt.nextInt();
        switch (opt){
            case 1:
                Scanner scanSide = new Scanner(System.in);
                double side = scanSide.nextDouble();
                double areaSqr = Math.pow(side,2);
                System.out.printf("A area do quadrado = %.2f", areaSqr);
                break;
            case 2:
                Scanner scanRad = new Scanner(System.in);
                double radius = scanRad.nextDouble();
                double areaCir = 3*Math.pow(radius,2);
                System.out.printf("Consirando que pi = 3, a area do circulo = %.2f", areaCir);
                break;
            default:
                System.out.println("Opção Inexistente");
                break;
        }
    }
}
