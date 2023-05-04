package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {

        Queue<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령의 수
        int N = Integer.parseInt(br.readLine());

        // 마지막 값
        int last = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]){
                // 정수 X를 큐에 넣는 연산
                case "push" :
                    queue.offer(Integer.parseInt(input[1]));
                    last = Integer.parseInt(input[1]);
                    break;
                // 가장 앞 정수를 빼고 그 수를 출력, 정수가 없는 경우에는 -1을 출력
                case "pop" :
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                // 큐에 들어있는 정수의 개수를 출력
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                // 비어있으면 1, 아니면 0
                case "empty" :
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                // 큐의 가장 앞 정수 출력. 정수가 없는 경우 -1
                case "front" :
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                // 큐의 가장 뒤 정수 출력. 정수가 없는 경우 -1
                case "back" :
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        } // for

        System.out.println(sb);


    }
}
