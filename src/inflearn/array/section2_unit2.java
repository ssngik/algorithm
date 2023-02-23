package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수
        int n = Integer.parseInt(br.readLine());

        // 학생 신장 배열
        int[] arr = new int[n];

        // 입력 받은 학생 신장 정보 배열에 저장
        StringTokenizer input = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(input.nextToken());

        // 볼 수 있는 최대 학생수
        int answer=1;

        // 가장 키가 큰 학생. 초기는 제일 앞 줄
        int max = arr[0];

        for(int i=1; i<n; i++)
            if(max<arr[i]){
                answer++;
                max = arr[i];
            }

        System.out.println(answer);
    }
}
