package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String answer="YES";

        input = input.toLowerCase();

//        for(int i=0; i<input.length()/2; i++){
//            if(input.charAt(i)!=input.charAt(input.length()-i-1)) answer = "NO";
//        }

        String tmp = new StringBuilder(input).reverse().toString();
        if(!tmp.equals(input)) answer="NO";


        System.out.println(answer);


    }
}
