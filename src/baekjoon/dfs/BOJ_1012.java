package baekjoon.dfs;

// BOJ_1012_유기농배추

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    // 상, 우, 하, 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int tc = 0; tc < t; tc++) {

            st = new StringTokenizer(br.readLine()); // 배추밭 정보
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이 10
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이 8
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
            arr = new int[N][M];                  // 배추밭
            check = new boolean[N][M];              // 방문 여부

            for (int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken()); // 심어져 있는 행 좌표
                int n = Integer.parseInt(st.nextToken()); // 심어져 있는 열 좌표

                arr[n][m] = 1; // 배추 심기
            }

            BOJ_1012 T = new BOJ_1012();
            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j]==1 && !check[i][j]){
                        answer++;
                        T.DFS(j, i);
                    }
                }
            }

            System.out.println(answer);


        } // tc
    } // main

    public void DFS(int x, int y){
        // 방문 Check
        check[y][x] = true;

        // 각 방향별 인접 배추 검사
        for (int i = 0; i < 4; i++) {
            int dirX = x + dx[i];
            int dirY = y + dy[i];

            // 인덱스 범위 검사
            if (!indexCheck(dirX, dirY)) continue;

            // 방문하지 않았다면
            if (!check[dirY][dirX] && arr[dirY][dirX]==1){
                DFS(dirX, dirY);
            }
        }

    }
    // 인덱스 범위 체크
    private boolean indexCheck(int dirX, int dirY) {
        return (dirX >= 0 && dirX < M && dirY >= 0 && dirY < N);
    }

} // class
