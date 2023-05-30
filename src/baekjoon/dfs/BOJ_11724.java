package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static boolean[] visited;
    static int[][] arr;
    static int N;
    static void DFS(int x){
        visited[x] = true;

        // 방문하지 않고, 연결되어 있다면
        for (int i = 1; i < N + 1; i++) {
            if (arr[x][i]==1 && !visited[i]){
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 무방향
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        int answer=0;
        for (int i = 1; i <N+1; i++) {
            if (!visited[i]){
                answer++;
                DFS(i);
            }
        }

        System.out.println(answer);

    }
}
