package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4673 {

    // d(75) = 75 + 7 + 5 = 87
    // 셀프넘버 -> 생성자가 없는 숫자 -> 셀프넘버 출력 -> 생성자가 있는 숫자 제외 출력
    public static int d(int num){
        int sum = num;

        while (num != 0){
            sum = sum + (num % 10);
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        boolean[] check = new boolean[10001];

        for(int i = 1; i <= 10000; i++){

            int n = d(i);

            if (n < 10001){
                check[n] = true; // 셀프넘버가 아닌 숫자 ( 생성자가 있는 숫자 )
            }
        }

        // 셀프넘버 출력 ( 생성자가 없는 숫자 ), d(i) 함수로 만들 수 없는 수
        for (int i = 1; i<=10000; i++){
            if (!check[i]){
                System.out.println(i);
            }
        }

    }
}
