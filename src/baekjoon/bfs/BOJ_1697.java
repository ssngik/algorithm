package baekjoon.bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {

    static int visited[] = new int[100001];
    static int N, K;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈이가 있는 위치
        K = sc.nextInt(); // 동생이 있는 위치

        if (N == K){
            System.out.println(0);
        }else{
            System.out.println(bfs(N));
        }

    }

    private static int bfs(int num){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()){
            int now = queue.poll();

            // 1. 한 칸씩 이동 ( X + 1 Or X - 1 )
            // 2. 2*X 의 위치로 이동
            int[] next = {now + 1, now - 1, now * 2};

            for (int move : next){

                // 범위가 벗어난 경우
                if (move < 0 || move >= 100001) continue;

                // 방문한 경우
                if (visited[move] > 0 || move == N) continue;

                // 이동
                queue.add(move);
                visited[move] = visited[now] + 1;

                // 동생을 찾은 경우
                if (move==K) return visited[move];
            }
        }

        return 0;
    }
}
