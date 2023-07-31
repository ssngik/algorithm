package programmers.Lv2;

import java.util.Stack;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> stack = new Stack<>();

            for (char x : s.toCharArray()){
                if (!stack.isEmpty() && stack.peek()==x) stack.pop();
                else stack.push(x);
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}
