package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1284 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // A 사
            int P = Integer.parseInt(st.nextToken()); // A 사의 1L당 요금

            // B사
            int Q = Integer.parseInt(st.nextToken()); // B 사의 기본요금
            int R = Integer.parseInt(st.nextToken()); // 월 사용량 기본 요금 기준 R 리터 ( R리터 이하 -> 기본 요금 : Q )
            int S = Integer.parseInt(st.nextToken()); // R 초과인 경우 1 리터당 S 원의 추가 요금

            // 한 달간 사용한 수도의 양
            int W = Integer.parseInt(st.nextToken());


            int aCost = W * P; // A 사의 요금
            int bCost = ( W <= R ) ? Q : (W - R) * S + Q; // B 사의 요금

            System.out.println("#"+ i + " " + Math.min(aCost, bCost));

        }

    }

}
