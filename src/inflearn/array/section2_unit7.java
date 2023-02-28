package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 문제의 개수
        int answer = 0; // 정답 ( 총 점수 )

        StringTokenizer st = new StringTokenizer(br.readLine()); // 채점 결과

        int[] res = new int[n]; // 채점 결과 배열

        for (int i = 0; i < n; i++) { // 채점 결과 저장
            res[i] = Integer.parseInt(st.nextToken());
        }

        int weight = 0; // 가산점

        for (int x : res) {
            if (x == 1) {
                answer++; // 총 점수 + 1
                answer = answer + weight; // 총 점수 + 가산점
                weight++; // 가산점 + 1;
            } else if (x == 0) {
                weight = 0;
            }

        }

        System.out.println(answer);

    }
}
