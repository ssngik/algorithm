// BOJ_10799_쇠막대기

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer=0;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){

            if(input.charAt(i)=='(') stack.push('('); // ( 라면 Stack push
            else{ // ) 라면
                stack.pop();
                if(input.charAt(i-1)==')') answer+=1; // 이전 괄호가 ) -> 막대 마지막 부분 -> + 1
                else answer+=stack.size(); // 이전 괄호가 ( 라면 레이저 -> 잘린 막대 수 더하기

            }


        }
        System.out.println(answer);


    }
}
