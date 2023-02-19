package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String answer="YES";


        input = input.toLowerCase().replaceAll("[^a-z]", "");

        String tmp = new StringBuilder(input).reverse().toString();

        if(!input.equals(tmp)) answer="NO";

        System.out.println(answer);



    }
}
