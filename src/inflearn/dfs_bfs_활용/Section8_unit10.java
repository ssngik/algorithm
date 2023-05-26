package inflearn.dfs_bfs_활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section8_unit10 {
    static int[][] arr;
    // 상 좌 하 우
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;
    static void DFS(int x, int y){
        if (x == 7 && y == 7) answer++;
        else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    DFS(nx, ny);
                    arr[nx][ny]=0;
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[1][1] = 1;
        DFS(1,1);

        System.out.println(answer);
    }
}
