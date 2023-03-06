package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section3_unit5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = n/2+1;
        int answer = 0, lt=0, sum=0;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) arr[i]=i+1;

        for (int rt = 0; rt < m; rt++) {
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n) answer++;
            }
        }
        System.out.println(answer);
    }
}
