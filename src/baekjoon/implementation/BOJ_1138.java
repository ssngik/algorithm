package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();

        int[] line = new int[N+1]; // input : 키가 1인 사람부터 자기보다 키가 큰 사람이 왼쪽에 몇 명 있었는지
        for (int i = 1; i <= N; i++) line[i] = Integer.parseInt(st.nextToken()); // Input

        for (int i = N; i >=1; i--) answer.add(line[i], i); // 키가 i인 사람이 line[i]번째 순서. (있으면 오른쪽으로 밀어냄)

        for (int x : answer) System.out.print(x + " "); // output : 줄을 선 순서대로 키를 출력
    }
}
