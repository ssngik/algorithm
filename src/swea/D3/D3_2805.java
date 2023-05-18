package swea.D3;
// 01
// 10 11 12
// 21

/*
02
11 12 13
20 21 22 23 24
31 23 33
42
 */

/*
03
12 13 14
21 22 23 24 25
30 31 32 33 34 35 36
41 42 43 44 45
52 53 54
63
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // TC 수

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine()); // 농장의 크기
            int answer = 0; // 수익

            // input 입력 & 배열 윗 부분 탐색
            for (int i = N / 2; i >= 0; i--) {
                String input = br.readLine();
                for (int j = i; j < N - i; j++) {
                    answer += input.charAt(j) - '0';
                }
            }

            // input 입력 & 배열 밑 부분 탐색
            for (int i = 1; i <= N / 2; i++){
                String input = br.readLine();
                for (int j = i; j < N - i; j++) {
                    answer += input.charAt(j) - '0';
                }
            }

            System.out.println("#" + tc + " " + answer);

        }

    }
}
