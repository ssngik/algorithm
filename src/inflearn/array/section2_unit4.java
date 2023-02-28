package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class section2_unit4 {
    // 배열 사용
//    public void solution(int n){
//        int[] answer = new int[n];
//        answer[0]=1;
//        answer[1]=1;
//
//        System.out.print(answer[0] + " " + answer[1] + " ");
//        for(int i=2; i<n; i++){
//            answer[i] = answer[i-2] + answer[i-1];
//            System.out.print(answer[i] + " ");
//        }
//    }


    public void solution(int n){

        // 배열 쓰지 않고
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++){
            c = a + b;
            System.out.print(c + " ");
            a=b;
            b=c;
        }
    }
    public static void main(String[] args) throws IOException {

        section2_unit4 T = new section2_unit4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        T.solution(n);



    }
}
