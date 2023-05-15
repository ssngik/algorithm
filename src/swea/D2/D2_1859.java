package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1859 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine()); // 매매가 수

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N]; // 매매가
            for (int j=0; j<N; j++) arr[j] = Integer.parseInt(st.nextToken());

            long sum = 0L; // 누적 마진합
            int max = 0; // 최대 순이익
            for (int k=N-1; k>=0; k--){
                if (arr[k] > max) max = arr[k];
                else{
                    int margin = max - arr[k]; // 마진
                    sum += margin; // 누적 마진합
                }
            }
            System.out.println("#" + i + " " + sum);
        } // TC

    } // Main
}
