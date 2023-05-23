package baekjoon.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_2446 {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();

        // 역 삼각
        for (int i=0; i<N; i++){
            // 공백
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 역삼각 별
            for (int j = i; j <N*2-1-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 삼각
        for (int i = 0; i < N-1; i++) {
            // 공백
            for (int j = 0; j < (N-1) -i -1; j++) {
                System.out.print(" ");
            }
            // 삼각형 별
            for (int j = 0; j < 3 + (i*2); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
