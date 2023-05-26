package inflearn.dfs_bfs_활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section8_unit13 {

    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static int[][] board;
    static int N;
    static void DFS(int x, int y){
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크, 1 체크
            if (nx >= 0 && nx < N && ny >= 0 && ny <N && board[nx][ny]==1){
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1){ // 1이면 진행
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);

    }
}
