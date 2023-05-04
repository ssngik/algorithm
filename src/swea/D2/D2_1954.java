package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 00 01 02
// 12 22
// 21 20
// 10 11

        /*
        1 2 3 4 5 6
       17 18 19 20 7
       16 25 26  21 8
       15 24 23 22 9
      14 13 12 11 10

         */

public class D2_1954 {

    // 우 하 좌 상
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testCase
        int t= Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){ // tc
            int n = Integer.parseInt(br.readLine()); // input

            int[][] arr = new int[n][n]; // n * n 크기의 배열
            int dir = 0; // 방향
            int x = 0, y = 0; // 삽입 지점

            // Start logic
            // 넣을 숫자
            for (int j = 1; j <= n * n ; j++) {
                // 1. 삽입
                arr[x][y] = j;

                // 2. 검사

                // 2.1 다음 좌표 추출
                int xNext = x + dx[dir];
                int yNext = y + dy[dir];

                // 2.2 방향을 전환해야 할 경우
                if(xNext > n-1 || yNext > n-1 || xNext<0 || yNext <0 || arr[xNext][yNext] > 0 )
                {
                    // 2.3 방향 전환
                    if( dir + 1 == 4) dir = 0;
                    else dir += 1;

                }

                // 3. 다음 위치로
                x += dx[dir];
                y += dy[dir];

            }

            System.out.println("#"+i);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }


        } // tc

    }
}
