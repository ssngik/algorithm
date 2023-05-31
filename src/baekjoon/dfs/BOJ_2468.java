package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int N; // 행과 열의 개수
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // index 범위 체크
    static boolean indexCheck(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    static void DFS(int x, int y, int height){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!indexCheck(nx, ny)) continue;  // 범위 벗어나는 경우
            if (visited[nx][ny]) continue;     // 이미 방문한 경우
            if (map[nx][ny] > height){        // 안전지대인 경우
                DFS(nx, ny, height);         // 탐색
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 행과 열의 개수
        map = new int[N][N];
        int maxLevel = Integer.MIN_VALUE; // 최대 수위 지정을 위한 변수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N; j++) {
                // 전체 도시가 잠기는 최대 수위를 미리 구함
                int tmp = Integer.parseInt(st.nextToken());
                maxLevel = Math.max(maxLevel, tmp);

                // input
                map[i][j] = tmp;
            }
        }

        int answer = 0; // 최대 안전지대 개수

        for (int height = 0; height < maxLevel+1; height++) {

            visited = new boolean[N][N];
            int cnt=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // 방문하지 않았고, 수위보다 높다면 (안전지대라면)
                    if (!visited[i][j] && map[i][j] > height){
                        cnt++;
                        DFS(i, j, height); // 안전 영역 탐색
                    }
                }
            }
            answer = Math.max(cnt, answer);
        } // H

        System.out.println(answer);

    }
}
