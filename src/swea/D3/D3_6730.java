package swea.D3;

import java.util.Scanner;

public class D3_6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int maxUp = 0, maxDown = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i < N; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff > 0 && diff > maxUp) {
                    maxUp = diff;
                } else if (diff < 0 && -diff > maxDown) {
                    maxDown = -diff;
                }
            }

            System.out.printf("#%d %d %d\n", t, maxUp, maxDown);
        }

        sc.close();
    }
}