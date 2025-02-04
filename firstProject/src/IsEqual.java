import java.util.Scanner;

public class IsEqual {
    public static void main(String[] args) {
        System.out.println("Digite um numero inteiro: ");
        Scanner scan1 = new Scanner(System.in);
        int num1 = scan1.nextInt();
        System.out.println("Digite mais um numero inteiro: ");
        Scanner scan2 = new Scanner(System.in);
        int num2 = scan2.nextInt();
        if (num1 != num2){
            System.out.println("Diferentes.");
            if(num1 > num2){
                System.out.println("Numero 1 maior que Numero 2");
            } else {
                System.out.println("Numero 2 maior que numero 1");
            }
        } else {
            System.out.println("Iguais");
        }
    }
}
