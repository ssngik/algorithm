package swea.D2;

import java.util.Scanner;

public class D2_1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            // 금액 N
            int n = sc.nextInt();

            int[] answer = new int[8];
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

            // 8 번
            for (int j = 0; j < answer.length; j++) {
                if( n >= money[j]) {
                    answer[j] = n / money[j];
                    n -= answer[j] * money[j];
                }
                else answer[j] = 0;

            }

            System.out.println("#" + i);
            for(int k=0; k<8; k++) System.out.print(answer[k] + " ");
            System.out.println();
        } // for i

    }
}
