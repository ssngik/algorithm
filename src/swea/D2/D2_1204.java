package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D2_1204 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testCase=1; testCase<=T; testCase++){
            int n = Integer.parseInt(br.readLine()); // 테스트케이스  번호

            int[] arr = new int[101]; // 빈도수 저장 배열

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<1000; i++){
                arr[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int answer = 0;
            for (int i=0; i<100; i++){
                if(arr[i] >= max){
                    max = arr[i];
                    answer = i;

                }
            }

            System.out.println("#" + testCase + " " + answer);
        }

    }
}
