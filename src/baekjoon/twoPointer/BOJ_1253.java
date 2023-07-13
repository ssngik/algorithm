package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {

        //long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        // 정렬
        Arrays.sort(arr);

        // -2 1 2 3 4
        for (int i = 0; i < N; i++) {
            int lt=0, rt=N-1;

            while (true){

                // 기준 숫자와 포인터가 같은 경우
                if (i==rt) rt--;
                else if (i==lt) lt++;

                // 좋은 수가 없는 경우
                if (lt >= rt) break;


                if (arr[i] > arr[lt] + arr[rt]) lt++;
                else if (arr[i] < arr[lt] + arr[rt]) rt--;
                else{
                    answer++;
                    break;
                }

            }
        }

        System.out.println(answer);

        //long end = System.currentTimeMillis();
        //System.out.println("수행시간: " + (end - start) + " ms");
    }
}
