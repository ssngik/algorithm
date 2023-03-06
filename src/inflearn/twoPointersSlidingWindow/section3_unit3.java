package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section3_unit3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int answer = Integer.MIN_VALUE; // 정답
        int n = Integer.parseInt(input[0]); // 영업일
        int k = Integer.parseInt(input[1]); // 연속 최대 매출일
        int[] sales = new int[n]; // 매출 목록

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) sales[i] = Integer.parseInt(st.nextToken());
        // 0 1 2 // 1 2 3
        for (int i = 0; i < n - k; i++) {
            int tmp=0;
            for (int j = i; j < i+k; j++) { // K 일씩 더함
                tmp+=sales[j];
            }
            answer = Math.max(tmp, answer);
        }

        System.out.println(answer);





    }
}
