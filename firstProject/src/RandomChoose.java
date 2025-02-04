import java.util.Random;
import java.util.Scanner;

public class RandomChoose {
    public static void main(String[] args) {
        int random = new Random().nextInt(100);
        int attempt = 0;
        while (attempt != 5) {
            attempt++;
            Scanner guess = new Scanner(System.in);
            int number = guess.nextInt();
            if (number == random){
                break;
            }
        }
    }
}
