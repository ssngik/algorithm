package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc=1; tc<=10; tc++){
            br.readLine();

            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE; // 최대값
            int right = 0; // 오른쪽 아래 대각선
            int left = 0; // 왼쪽 아래 대각선

            for (int i = 0; i < 100; i++) {
                int row = 0; // 행
                int col = 0; // 열

                right += arr[i][i];
                left += arr[i][99-i];
                for (int j = 0; j < 100; j++) {
                    row += arr[i][j];
                    col += arr[j][i];
                }
                max = Math.max(max, row);
                max = Math.max(max, col);
            }
            max = Math.max(max, right);
            max = Math.max(max, left);

            System.out.println("#" + tc + " " + max);
        }

    }
}
