package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class section4_unit1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String answer = "YES";

        Stack<Character> stack = new Stack<>();

        for (char x : input.toCharArray()) {
            if (x == '(') stack.push(x); // 여는 괄호 push

            else { // 닫는 괄호면
                if (stack.isEmpty())  // 닫는 괄호인데 비어있다면 올바른 괄호가 아님
                {
                    answer = "NO";
                    break;
                }
                else
                {
                    stack.pop();  // 비어있지 않으면 pop
                }
            }

        }

        if (stack.isEmpty()) System.out.println(answer);
        }
    }
