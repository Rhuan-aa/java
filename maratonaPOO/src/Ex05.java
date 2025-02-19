import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tournment = new int[16];
        int kungIndex = 0, luIndex = 0;

        for (int i = 0; i < 16; i++) {
            tournment[i] = scan.nextInt();
            if (tournment[i] == 9) luIndex = i;
            if (tournment[i] == 1) kungIndex = i;
        }

        int round = 0;
        while (kungIndex / 2 != luIndex / 2) { // Enquanto não estiverem no mesmo "par"
            kungIndex /= 2;
            luIndex /= 2;
            round++;
        }

        String combat = switch (round) {
            case 0 -> "oitavas";
            case 1 -> "quartas";
            case 2 -> "semifinal";
            default -> "final";
        };

        System.out.println(combat);
    }
}
