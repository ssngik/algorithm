package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class section5_unit2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();

        for(char x : input.toCharArray()){
            if(x==')'){
                while (stack.pop()!='(');
            }else stack.push(x);
        }

        for(char x : stack) System.out.print(x);
    }
}
