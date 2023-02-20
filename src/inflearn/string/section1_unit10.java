package inflearn.string;


import java.util.Scanner;

public class section1_unit10 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 입력 받은 문자열
        char c = sc.next().charAt(0); // 입력 받은 문자

        int p = 1000; // 기준점

        int[] answer = new int[str.length()]; // 정답 배열


        // 좌측에서 우측으로 탐색
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i)==c) // 입력 받은 문자와 같은 문자라면
            {
                p=0; // 기준점은 0으로 초기화 됨
                answer[i]=p; // 0 을 입력 ( 떨어진 거리가 0 이기 때문에)
            }
            else
            {
                answer[i]=++p;
            }
        }
        p=1000; // 기준 초기화

        // 우측에서 좌측으로 탐색
        for (int i = str.length()-1; i >=0; i--) {
            if(str.charAt(i)==c){
                p=0;
                answer[i]=p;
            }else{
                p++;
                answer[i] = Math.min(answer[i], p); // 이미 입력되어 있는 것과 더 짧은 거리 넣음
            }
        }

        for(int x: answer) System.out.print(x + " "); // 정답 출력


    }
}

