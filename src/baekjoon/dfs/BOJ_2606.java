package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2606 {
    static int n, answer=0;
    static int[][] graph;
    static int[] ch;

    static void DFS(int v){

        for (int i=1; i<=n; i++){
            if (graph[v][i] == 1 && ch[i]==0){
                answer++;
                ch[i]=1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        graph = new int[n+1][n+1];
        ch = new int[n+1];

        int m = Integer.parseInt(br.readLine()); // 네으퉈크 상 직접 연결되어 있는 컴퓨터 쌍의 수

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            graph[x][y] = graph[y][x] = 1; // 탐색 경로 배열
        }
        ch[1] = 1; // 방문여부 체크
        DFS(1);

        System.out.println(answer);
    }
}
