package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1105 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String L = input[0];
        String R = input[1];

        int answer = 0;

        // 자릿수가 같은 경우
        if (L.length() == R.length()){
            for (int i=0; i<L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) break;

                if (L.charAt(i)=='8') answer++;

            }
        }

        System.out.println(answer);

    }
}
