package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444 {
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new int[N+1];
        list = new ArrayList<>();

        for (int i=0; i<=N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i=1; i<=N; i++) Collections.sort(list.get(i));

        bfs(R);

        for (int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }

    }
    static void bfs(int start){

        Queue<Integer> queue = new LinkedList<>();
        int cnt=1;

        queue.offer(start); // 시작 지점
        visited[start] = cnt++;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for (int num : list.get(node)){

                if (visited[num]!=0) continue;

                queue.offer(num);
                visited[num] = cnt++;
            }
        }

    }
}
