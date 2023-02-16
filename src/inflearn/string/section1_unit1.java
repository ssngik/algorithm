// 1. 문자 찾기

package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer=0;
        String inputString = br.readLine(); // 문자열 input
        char inputChar = br.readLine().charAt(0); // 문자 input

        inputString = inputString.toUpperCase(); // 대소문자 구분 x
        inputChar = Character.toUpperCase(inputChar);


        for(char x : inputString.toCharArray())
            if(x==inputChar)
                answer++;


        System.out.println(answer);
    }
}
