// 4. 단어 뒤집기

package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class section1_unit4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n 개의 단어

        String[] input = new String[n]; // n 개의 input 배열

        for(int i=0; i<n; i++) input[i] = br.readLine();

        for(String x : input){
            int lt=0, rt=x.length()-1;

            char[] s = x.toCharArray();

            while(lt<rt){ // swap
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;

            }

            System.out.println(s);

        }



    }
}
