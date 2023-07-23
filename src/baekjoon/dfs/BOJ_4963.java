package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static int w, h;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이

            int answer = 0;
            if (w==0 && h==0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1은 땅, 0은 바다
            for (int i=0; i < h; i++){
                for (int j = 0; j < w; j++) {
                    if (map[i][j]==1 && !visited[i][j]){
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(answer);

        }
    }
    static void dfs(int x, int y){

        // 방문 체크
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue; // 범위를 벗어난 경우
            if (visited[nx][ny]) continue; // 이미 방문한 경우
            if (map[nx][ny]==0) continue; // 바다인 경우

            dfs(nx, ny); // 탐색
            visited[nx][ny] = true; // 방문 체크
        }

    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
