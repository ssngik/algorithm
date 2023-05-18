package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1208 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t=1; t<=10; t++){
            int dump = Integer.parseInt(br.readLine()); // 덤프 횟수
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[100];
            // input
            for(int i=0; i<100; i++) arr[i] = Integer.parseInt(st.nextToken());

            // 배열 정렬
            Arrays.sort(arr);

            for(int i=0; i<dump; i++){
                arr[0]++; // 최소값 1 증가
                arr[99]--; // 최대값 1 감소
                Arrays.sort(arr); // 재정렬
            }

            int answer = arr[99]-arr[0];
            System.out.println("#"+t+ " " +  answer);
        }

    }
}
