package baekjoon.queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // N 번째 큰 수

        StringTokenizer st;

        PriorityQueue<Integer> pQueueHighest = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 / 높은 순


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                pQueueHighest.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n-1; i++) pQueueHighest.poll();

        System.out.println(pQueueHighest.peek());

    }
}
