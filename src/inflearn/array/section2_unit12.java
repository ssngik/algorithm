package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit12 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int answer = 0; // 정답 ( 짝을 만들 수 있는 총 경우 )
        int n = Integer.parseInt(input[0]); // 학생 수
        int m = Integer.parseInt(input[1]); // 테스트 결과
        int[][] arr = new int[m][n]; // 각 학생 테스트 결과

        // 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt=0; // 멘토-멘티 성립
                for (int k = 0; k < m; k++) {
                    int pi=0, pj=0;
                    for (int l = 0; l < n; l++) {
                        if(arr[k][l]==i) pi=l; // 그 학생이 l 등
                        if(arr[k][l]==j) pj=l; // 그 학생이 l 등
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m){ // 테스트 개수와 같다면
                    answer++;
                }
            }
        }
        System.out.println(answer);




    }
}
