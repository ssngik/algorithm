package inflearn.string;

import java.util.Scanner;

public class section1_unit11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        input+=" ";

        StringBuilder sb = new StringBuilder();



        int cnt=1;

        for(int i=0; i<input.length()-1; i++){
            if(input.charAt(i)==input.charAt(i+1)) cnt++; // 다음 문자와 같다면 count ++;
            else{
                sb.append(input.charAt(i)); // 다음 문자와 다르다면 concat
                if(cnt>1) sb.append(cnt); // cnt 1은 생략
                cnt=1;
            }
        }

        System.out.println(sb);
    }
}
