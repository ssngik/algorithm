package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section3_unit4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // n 개의 수
        int m = Integer.parseInt(input[1]); // 특정숫자 M
        int[] arr = new int[n]; // 연속 부분 수열
        int lt=0, sum=0, answer=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int rt = 0; rt <n ; rt++) { // rt 증가
            sum+=arr[rt]; // 더하기
            if(sum==m) answer++; // 확인
            while(sum>=m){
                sum-=arr[lt++]; // lt 값 뺀 다음 증가
                if(sum==m) answer++;
            }

        }
        System.out.println(answer);

    }
}
