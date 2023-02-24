package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수 N

        String[] arr = new String[N]; // 알파벳 저장을 위한 배열

        for (int i = 0; i <N ; i++)  arr[i] = br.readLine(); // 알바펫 저장

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2){
                if(s1.length()==s2.length()) return s1.compareTo(s2); // 길이가 같으면
                else return s1.length() - s2.length(); // else
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');

        for (int i = 1; i <N ; i++) { // 중복이 되지 않는다면 sb.append
            if(!arr[i].equals(arr[i-1])) sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }

}
