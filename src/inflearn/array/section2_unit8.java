package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit8 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()); // 점수

        int[] score = new int[n]; // 점수

        for (int i = 0; i <n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int rank = 1; // 등수 ( 초기 : 1 등)
            for (int j = 0; j < n; j++) {
                if(score[i]<score[j]) rank++;
            }
            System.out.print(rank + " ");
        }


    }
}
