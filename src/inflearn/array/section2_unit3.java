package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class section2_unit3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n]; // A
        int[] B = new int[n]; // B

        StringTokenizer st_A = new StringTokenizer(br.readLine()); // A 의 정보
        StringTokenizer st_B = new StringTokenizer(br.readLine()); // B 의 정보

        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st_A.nextToken());
            B[i] = Integer.parseInt(st_B.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if(A[i]==B[i]) System.out.println("D"); // 비긴 경우
            else if(A[i] == 1 && B[i]==3) System.out.println("A"); // A 가 이긴 경우
            else if(A[i]==2 && B[i]==1) System.out.println("A"); // A 가 이긴 경우
            else if(A[i]==3 && B[i]==2) System.out.println("A"); // A 가 이긴 경우
            else System.out.println("B"); // B 가 이긴 경우
        }


    }
}
