package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit6 {
    public static boolean isPrime(int num){
        if(num==1) return false; // 1 은 소수가 아님

        for (int i = 2; i <num; i++) // 1 과 자기 자신 외 나머지 0 으로 나눠지는 수가 있는 경우
            if(num%i==0) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int res = 0; // 뒤집은 결과

            while(tmp>0){ // 수 뒤집기
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            // 뒤집은 수가 소수라면 출력
            if(isPrime(res)) System.out.print(res + " ");

        }


    }
}
