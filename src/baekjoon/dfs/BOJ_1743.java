package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map; // 통로
    static boolean[][] visited;
    static int N, M, answer, count;
    static void dfs(int x, int y){

        count++; // 개수 체크
        visited[x][y] = true; // 방문 체크

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위가 벗어난 경우
            if (map[nx][ny] == 0) continue; // 음식물이 없는 경우
            if (visited[nx][ny]) continue; // 이미 방문한 경우

            dfs(nx, ny);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 통로의 세로 길이
        M = Integer.parseInt(st.nextToken()); // 통로의 가로 길이
        int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수

        map = new int[N][M]; // 통로
        visited = new boolean[N][M]; // 방문 체크
        // r : 위에서부터 떨어진 좌표
        // c : 왼쪽에서부터 떨어진 좌표

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j]==1){
                    count = 0; // 쓰레기 개수 초기화
                    dfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);

    }
}
