package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 입력 받은 문자열

        Stack<String> lStack = new Stack<>(); // Left Stack
        Stack<String> rStack = new Stack<>(); // Right Stack

        for(int i=0; i<str.length(); i++) lStack.push(str.substring(i, i+1)); // left Stack 에 모두 넣기

        int M = Integer.parseInt(br.readLine()); // 명령어의 개수를 나타내는 정수 M

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "L": // 커서 왼쪽으로
                    if(!lStack.isEmpty()) rStack.push(lStack.pop());
                    break;
                case "D": // 커서 오른쪽으로
                    if(!rStack.isEmpty()) lStack.push(rStack.pop());
                    break;
                case "B": // 커서 왼쪽 문자 삭제
                    if(!lStack.isEmpty()) lStack.pop();
                    break;
                case "P": // 문자를 커서 왼쪽에 추가함
                    lStack.push(st.nextToken());
                    break;

            }
        }

        while (!lStack.isEmpty()) rStack.push(lStack.pop()); // left stack to right stack

        while (!rStack.isEmpty()) bw.write(rStack.pop());

        bw.flush();
        bw.close();

    }
}

