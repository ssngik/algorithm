package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class section3_unit6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 길이
        int k = Integer.parseInt(input[1]); // 변경 가능 횟수
        int lt=0, answer=0, cnt=0;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int rt = 0; rt < n; rt++) {
            if(arr[rt]==0) cnt++;
            while (cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer=Math.max(answer, rt-lt+1);
        }
        System.out.println(answer);


    }
}
