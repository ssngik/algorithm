// BOJ_4889_안정적인_문자열

package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        int t = 1; // testcase

        while (true){
            String input = br.readLine();

            if(input.charAt(0)=='-') break; //  '-'가 한 개 이상 종료

            int modify=0;

            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='}'){
                    if(stack.isEmpty()) // stack 이 비어있다면 '{' 로 바꾸어 저장, 수정 횟수 +1
                    {
                        stack.push('{');
                        modify++;
                    }else{ // stack 이 비어있지 않으면 pop
                        stack.pop();
                    }
                }else{ // '{' 인 경우 push
                    stack.push(input.charAt(i));
                }

            }

            // '{' '{' 라면 한 번 변경해야함. + 수정 횟수
            int answer = stack.size()/2 + modify;

            System.out.println(t + ". " + answer);

            // testcase 횟수
            t++;

            // stack 초기화
            stack.clear();

        }


    }
}
