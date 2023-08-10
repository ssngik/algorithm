package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BOJ_2573 {
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;


    // 빙하가 분리되어 있는지 확인
    static int isSeparated(){

        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    cnt++;
                    //if (cnt >= 2) return cnt;
                }
            }
        }
        return cnt;
    }

    // 빙산 개수 count
    static void dfs(int x, int y, boolean[][] visited){
        // 방문 체크
        visited[x][y] = true;

        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 이미 방문한 경우
            if (visited[nx][ny]) continue;

            // 빙산인 경우
            if (map[nx][ny] != 0){
                dfs(nx, ny, visited);
            }
        }
    }

    // 주변 바다수만큼 얼음 녹이기
    static void melting(){

        Queue<Point> Q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0){
                    Q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()){
            Point p = Q.poll();

            int x = p.x; int y = p.y;
            int sea = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 이미 방문한 경우
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 0) sea++; // 주변의 바다 수
            }

            // 0 보다 작아지는 경우는 0, 아닌 경우 주변 바다수만큼 감소
            if (map[x][y] - sea < 0) map[x][y] = 0;
            else map[x][y] -= sea;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true){

            // 분리된 빙산이 두 개가 되는 경우 종료
            if (isSeparated()>1){
                break;
            }else if (isSeparated()==0){ // 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 0을 출력
                answer = 0;
                break;
            }


            melting(); // 빙산 녹이기
            answer++;
        }


        System.out.println(answer);
    }
}
