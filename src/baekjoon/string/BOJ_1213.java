// BOJ_1213_팰린드롬 만들기

package baekjoon.string;

import java.io.*;
import java.util.*;


public class BOJ_1213 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // input 문자열

        StringBuilder sb;

        int[] arr = new int[26]; // 알파벳 A ~ Z

        for(int i=0; i<input.length(); i++) arr[input.charAt(i)-65]++; // 알파벳 숫자 count

        if(input.length()%2==0){ // 문자열 개수가 짝수라면

            String rev=""; // reverse
            String answer=""; // 정답

            sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                if(arr[i]%2==1) // 홀수개인 알파벳이 있다면
                {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else
                {
                    if(arr[i]>0)
                        for(int j=0; j<arr[i]/2; j++) sb.append((char)(i+65));
                }
            } // End for
            System.out.println(answer + sb.toString() + sb.reverse());

        }
        else // 문자열 개수가 홀수라면
        {
            sb = new StringBuilder();

            String answer=""; // 정답
            String mid=""; // 중간 알파벳
            String rev=""; // reverse

            int odd=0;

            for (int i = 0; i < arr.length; i++) { // 알파벳 전체 검사.
                if(odd>1) { // 홀수인 알파벳이 한 개 초과라면 종료
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                if(arr[i]%2==1){ // 알파벳 개수가 홀수면
                    odd++;
                    mid+= (char) (i+65); // 가운데 알파벳으로 지정
                    arr[i]--;
                }

                if(arr[i]>=2)
                    for(int j =0; j<arr[i]/2; j++) sb.append((char)(i+65));

            }

            answer+=sb;
            rev = sb.reverse().toString();

            System.out.println(answer+mid+rev);

        }

    }
}
