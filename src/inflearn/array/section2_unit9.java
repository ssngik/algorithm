package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit9 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행, 열 각각의 합
        int sum1, sum2;
        // 정답
        int answer = Integer.MIN_VALUE;

        // 행, 열 크기 비교
        for (int i = 0; i < n; i++) {
            sum1=sum2=0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j]; // 행의 합
                sum2 += arr[j][i]; // 열의 합
            }
            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
        }

        sum1=sum2=0;
        // 대각선 비교
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[n-i-1][n-i-1];
            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
        }

        System.out.println(answer);



    }
}
