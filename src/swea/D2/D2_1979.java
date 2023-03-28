package swea.D2;

import java.util.Scanner;

public class D2_1979 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // input
        int t = scan.nextInt();
        for(int tc=1; tc<=t; tc++) {
            int N = scan.nextInt();
            int K = scan.nextInt();

            int[][] puzzle = new int[N][N];
            int ans = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    puzzle[i][j] = scan.nextInt();
                }
            }

            // 가로부터 들어갈 수 있는곳 찾기(흰색: 1, 검은색: 0)
            for(int i=0; i<N; i++) {
                int colCheck = 0;
                for(int j=0; j<N; j++) {

                    // 검은색이면 0으로 초기화, 흰색이면 +1
                    if(puzzle[i][j] == 0) {

                        // 검은색일때, 앞에 흰칸이 K 개 인 경우 -> 단어가 올 수 있음
                        if(colCheck == K) {
                            ans ++;
                        }
                        colCheck = 0;
                    } else {
                        colCheck += 1;
                    }
                }

                // 퍼즐의 가로가 길이 K 와 맞을경우 +1
                if(colCheck == K) {
                    ans ++;
                }
            }

            // 세로에 들어갈 수 있는 자리 찾기
            for(int i=0; i<N; i++) {
                int rowCheck = 0;
                for(int j=0; j<N; j++) {

                    // 검은색이면 0으로 초기화, 흰색이면 +1
                    if(puzzle[j][i] == 0) {

                        // 검은색일때, 앞에 흰칸이 K 개 인 경우 -> 단어가 올 수 있음
                        if(rowCheck == K) {
                            ans ++;
                        }
                        rowCheck = 0;
                    } else {
                        rowCheck += 1;
                    }
                }

                // 퍼즐의 세로가 길이 K와 맞을경우 +1
                if(rowCheck == K) {
                    ans ++;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }

        scan.close();
    }

}