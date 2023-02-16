// 5. 특정 문자 뒤집기

package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit5 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int lt=0, rt=input.length()-1;
        char[] chr = input.toCharArray();

        while(lt<rt){
            if(!Character.isAlphabetic(chr[lt])) lt++;
            else if(!Character.isAlphabetic(chr[rt])) rt--;
            else{
                char tmp = chr[lt];
                chr[lt]=chr[rt];
                chr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(chr);

    }
}
