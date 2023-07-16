package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        int M = Integer.parseInt(st.nextToken()); // 신뢰 관계 수

        answer = new int[N+1];
        list = new ArrayList<>();

        for (int i=0; i<=N; i++) list.add(new ArrayList<>());

        // A가 B를 신뢰하는 경우 -> B를 해킹하면, A도 해킹 가능
        // input A B -> A가 B를 신뢰.
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b); // b 를 신뢰하는 list[a]
        }

        for (int i=1; i<=N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;

        // 최댓값
        for (int i=1; i<=N; i++){
            max = Math.max(max, answer[i]);
        }

        for (int i=1; i<=N; i++){
            if (answer[i]==max){
                System.out.print(i + " ");
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            // now -> num
            // now가 num을 신뢰함
            for (int num : list.get(now)){
                if (!visited[num]){
                    visited[num] = true;

                    answer[num]++;
                    queue.add(num);
                }
            }
        }
    }

}
