package swea.D2;

import java.io.*;
import java.util.*;
public class D2_1946 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            System.out.println("#" + i);

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                String C = st.nextToken(); // 알파벳
                int K = Integer.parseInt(st.nextToken()); // 연속된 개수로 주어지는 수

                for (int k = 0; k < K; k++) {
                    sb.append(C);

                    if (sb.length() == 10) { // 원본 문서 너비가 10이 된 경우
                        System.out.println(sb);
                        sb = new StringBuilder(); // 초기화
                    }
                }
            }
            if (sb.length()>0) System.out.println(sb); // 길이 10 미만의 남아있는 문서 출력
        }

    }
}
