package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

    // 대각선 포함 시계방향 회전

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 너비, 높이
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w==0 && h==0) break; // 0, 0 인 경우 입력 종료

            int answer = 0;

            map = new int[h][w];
            visited = new boolean[h][w];

            // 입력 / 1 : 땅 , 0 : 바다
            for (int i=0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j]==1 && !visited[i][j]) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(answer);

        } // while
    } // psvm

    static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y));

        while (!queue.isEmpty()){
            Point p = queue.poll();

            for (int i=0; i<dx.length; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue; // 범위
                if (visited[nx][ny]) continue; // 이미 방문한 경우
                if (map[nx][ny]==0) continue;

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny));
            }
        }
    }




}
