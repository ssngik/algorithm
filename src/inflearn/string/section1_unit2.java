package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String answer = "";
        for(char x : input.toCharArray()){
            if(x>=97) answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }

        System.out.println(answer);

    }
}
