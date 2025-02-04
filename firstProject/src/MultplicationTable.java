import java.util.Scanner;

public class MultplicationTable {
    public static void main(String[] args) {
        System.out.println("Digite um inteiro: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 1; i <= 10; i++) {
            int tableNum = num*i;
            System.out.printf("%dx%d = %d\n", num, i, tableNum);
        }
    }
}
