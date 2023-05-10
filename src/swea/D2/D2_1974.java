package swea.D2;

import java.util.*;
import java.io.*;

public class D2_1974 {
    static int[][] map = new int[9][9];
    static int flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        // input 입력
        for (int i = 1; i <= tc; i++) {
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 스도쿠 검증
            boolean flag = true;
            for (int j = 0; j < 9; j++) {
                int rowSum = 0, colSum = 0;
                // 행, 열 스도쿠 검증 탐색
                for (int k = 0; k < 9; k++) {
                    rowSum += map[j][k];
                    colSum += map[k][j];
                }
                if (rowSum != 45 || colSum != 45) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("#" + i + " " + 0);
                continue;
            }

            // 작은 격자 체크
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    int squareSum = 0;
                    for (int x = j; x < j + 3; x++) {
                        for (int y = k; y < k + 3; y++) {
                            squareSum += map[x][y];
                        }
                    }
                    if (squareSum != 45) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }

            }

            if (!flag) {
                System.out.println("#" + i + " " + 0);
            } else {
                System.out.println("#" + i + " " + 1);
            }

        } // tc
    }
}
