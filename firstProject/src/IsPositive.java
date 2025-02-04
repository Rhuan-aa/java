import java.util.Scanner;

public class IsPositive {
    public static void main(String[] args) {
        System.out.println("Digite um numero: ");
        Scanner leitura = new Scanner(System.in);
        int number = leitura.nextInt();
        if (number >= 0){
            System.out.println("Positivo");
        } else {
            System.out.println("Negativo");
        }
    }
}
