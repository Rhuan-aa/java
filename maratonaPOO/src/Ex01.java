import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] array = new int[N];
        int sequence = 1;
        int previousV = 0;
        int j = 0;
        for (int i = 0; i < N; i++) {
            int V = scan.nextInt();
            if (i != 0) {
                if (V == previousV) sequence++;
                else {
                    array[j] = sequence;
                    sequence = 1;
                    j++;
                }
            }
            previousV = V;
        }
        array[j] = sequence;

        int greatestSequence = 1;
        for (int num : array){
            if (num > greatestSequence) greatestSequence = num;
        }

        System.out.println(greatestSequence);
    }
}
