package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit11 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수
        int[][] arr = new int[n+1][6]; // 학급 소속
        int answer = 0; // 정답
        int max_count = Integer.MIN_VALUE; // 최대 같은 반 횟수

        for (int i = 1; i <=n; i++) { // input
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <=5 ; k++) {
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max_count){ // 최대값 최신화
                max_count=cnt;
                answer=i;
            }
        }

        System.out.println(answer);



    }
}
