import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int matOrd = scan.nextInt();
        int[][] matrix = new int[matOrd][matOrd];
        int[] sumLine = new int[matOrd];
        int[] sumColumn = new int[matOrd];
        int greatestSum = 0;

        for (int i = 0; i < matOrd; i++) {
            for (int j = 0; j < matOrd; j++) {
                matrix[i][j] = scan.nextInt();
                sumLine[i] += matrix[i][j];
                sumColumn[j] += matrix[i][j];
            }
        }

        for (int i = 0; i < matOrd; i++) {
            for (int j = 0; j < matOrd; j++) {
                int sum = sumLine[i]+sumColumn[j]-(2*matrix[i][j]);
                if (sum > greatestSum) greatestSum = sum;
            }
        }

        System.out.println(greatestSum);
    }
}
