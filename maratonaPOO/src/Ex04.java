import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String result = "Y";
        int[][] grid = new int[10][10];
        int numOfShips = scan.nextInt();

        for (int i = 0; i < numOfShips; i++) {
            int D = scan.nextInt();
            int L = scan.nextInt();
            int R = scan.nextInt();
            int C = scan.nextInt();

            R--;
            C--;

            if (D == 0) {
                if (C+L > 10){
                    result = "N";

                } else {
                    for (int j = C; j < C + L; j++) {
                        if (grid[R][j] != 0)
                        {
                            result = "N";
                            break;
                        }
                    }
                    if ("Y".equals(result)) {
                        for (int j = C; j < C + L; j++) {
                            grid[R][j] = 1;
                        }
                    }
                }
            } else {
                if (R + L > 10){
                    result = "N";
                } else {
                    for (int j = R; j < R + L; j++) {
                        if (grid[j][C] != 0)
                        {
                            result = "N";
                            break;
                        }
                    }
                    if ("Y".equals(result)) {
                        for (int j = R; j < R + L; j++) {
                            grid[j][C] = 1;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
