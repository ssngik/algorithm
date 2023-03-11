package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class section5_unit5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer=0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='(') stack.push('(');
            else{
                stack.pop();
                if(input.charAt(i-1)=='(') answer+=stack.size();
                else answer++;
            }
        }

        System.out.println(answer);

    }
}
