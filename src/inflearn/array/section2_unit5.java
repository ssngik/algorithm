package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section2_unit5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] check = new int[n+1]; // 체크 배열

        int answer = 0;

        for(int i=2; i<=n; i++){
            if(check[i]==0) {
                answer++;
                for(int j=i; j<=n; j+=i) check[j]=1;
            }

        }

        System.out.println(answer);
    }
}
