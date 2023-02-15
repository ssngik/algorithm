package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002 {
    public static int solution(int x1, int y1, int r1, int x2, int y2, int r2){

        int distance = (int)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

        // 두 원이 겹치는 경우,
        if(x1 == x2 && y1 == y2 && r1 == r2) return -1;

            // 떨어져 있는 경우
        else if(distance > Math.pow(r1+r2, 2)) return 0;

            // 내접
        else if(distance== Math.pow(r1-r2, 2)) return 1;

            // 원 안에 있을 때
        else if(distance < Math.pow(r2-r1, 2)) return 0;

            // 외접
        else if(distance == Math.pow(r1+r2, 2)) return 1;

        else return 2;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // TK 의 수

        int x1, y1,  r1, x2, y2, r2;

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            System.out.println(solution(x1, y1, r1, x2, y2, r2));

        }

    }
}
