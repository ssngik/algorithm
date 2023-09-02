package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1337 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) { // 연속되는 원소가 있는 경우
                    arr[i]++;
                }
            }
        }

        // 오름차순 정렬 후 연속되는 최소 원소 (첫 번째 인덱스) 출력
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
