package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7571 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 격자 공간의 크기
        int M = Integer.parseInt(st.nextToken()); // 점들의 개수

        int[] xArr = new int[M];
        int[] yArr = new int[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            // x, y 좌표 정보 따로 받음
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int x = xArr[M/2]; // 중앙값
        int y = yArr[M/2]; // 중앙값
        int answer = 0;
        for (int i = 0; i < M; i++) {
            answer += Math.abs(x - xArr[i]);
            answer += Math.abs(y - yArr[i]);
        }

        System.out.println(answer);
    }
}
