package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class section5_unit7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Character> Q = new LinkedList<>();
        String need = br.readLine(); // 필수 이수과목
        String plan = br.readLine(); // 수업 계획
        String answer="YES";

        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()){
            if(Q.contains(x)){
                if(x!=Q.peek()){
                    answer="NO";
                    break;
                }else Q.poll();
            }
        }
        // loop 끝에도 필수과목이 남아있는 경우
        if(!Q.isEmpty()) answer="NO";

        System.out.println(answer);
    }
}
