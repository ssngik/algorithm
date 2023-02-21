package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit12{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        String input = br.readLine();
        StringBuilder answer = new StringBuilder();

        input = input.replace('#', '1').replace('*', '0'); // # -> 1 ||| * -> 0

        for (int i = 0; i <n; i++) {
            answer.append((char)Integer.parseInt(input.substring(0, 7), 2)); // 2진수 -> 10진수 -> 아스키 번호로 변환
            input=input.substring(7);
        }

        System.out.println(answer);

    }
}
