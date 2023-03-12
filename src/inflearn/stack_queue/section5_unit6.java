package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class section5_unit6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]); // 외치는 숫자
        int answer=0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) queue.offer(i);

        while (!queue.isEmpty()){
            for(int i=1; i<k; i++) queue.offer(queue.poll());
            queue.poll();
            if(queue.size()==1) {
                System.out.println(queue.poll());
                break;
            }

        }

    }
}
