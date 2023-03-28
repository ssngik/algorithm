package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class D2_2001 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // input
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt(); // N x N 배열
            int M = sc.nextInt(); // M x M 크기의 파리채
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int max_num=0;
            for(int a=0; a<=N - M; a++){ // start point
                for (int b = 0; b<=N - M; b++) { // start point
                    int sum=0;
                    for(int c=0; c < M; c++){ // swatter
                        for(int d=0; d < M; d++){ // swatter
                            sum += arr[a + c][b + d]; // start point + swatter
                        }
                    }
                    if(max_num<sum) max_num=sum; // swap
                }
            }
            System.out.println("#" + test_case + " " + max_num);
        }



        sc.close();
    }

}
