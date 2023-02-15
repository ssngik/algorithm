// https://www.acmicpc.net/problem/2075
// BOJ_2075_N번째 큰 수

package baekjoon.dataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // N 번째 큰 수

        StringTokenizer st;

        int[] arr = new int[n*n];
        int arrIndex = 0; // 1차원으로 받기 위해

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[arrIndex++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬


        System.out.println(arr[n*n-n]); // 전체에서 찾고자하는 개수만큼 뺌

    }


}
