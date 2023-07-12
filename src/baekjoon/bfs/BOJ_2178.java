package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true; // 출발지

        // 탐색 시작
        bfs(N, M);

        // 정답 출력
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int n, int m){

        Queue<int[]> queue = new LinkedList<>();

        // 출발
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                // 범위 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 방문, 이동가능 여부 체크
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                // 가능한 경우
                queue.add(new int[] {nx, ny});
                map[nx][ny] = map[now[0]][now[1]] + 1; // 거리 증가
                visited[nx][ny] = true; // 방문 체크
            }
        }
    }

}
