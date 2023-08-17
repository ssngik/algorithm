package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Section10_unit5 {
    static int N, M;
    static int[] dy; // i 금액을 만드는데 드는 최소 동전 개수

    static int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]] + 1); // 기존값보다 작으면 바꿔줌
            }
        }
        return dy[M];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 동전의 종류개수

        int[] arr = new int[N]; // 동전 종류
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); // 거슬러줄 금액
        dy = new int[M+1];
        System.out.println(solution(arr));
    }
}
