package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static boolean[] visited;
    static int N; // 정점의 개수
    static int[][] adj;


    public static void dfs (int start){
        // 방문
        visited[start] = true;
        // 출력
        System.out.print(start + " ");

        // 탐색
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue; // 이미 방문한 경우

            if (adj[start][i] == 1 ) dfs(i); // 유효한 탐색인 경우
        }

    }

    public static void bfs (int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;


        while (!queue.isEmpty()){
            int node = queue.poll();

            System.out.print(node + " ");
            for (int i=1; i <= N; i++){
                if (visited[i]) continue; // 이미 방문한 경우

                // 유효한 탐색인 경우
                if (adj[node][i]==1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        adj = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 인접행렬
            adj[a][b] = adj[b][a] = 1;
        }

        // dfs 탐색
        dfs(V);

        // 방문 배열 초기화
        Arrays.fill(visited, false);

        System.out.println();

        // bfs 탐색
        bfs(V);
    }
}
