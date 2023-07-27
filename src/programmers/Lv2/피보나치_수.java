package programmers.Lv2;

public class 피보나치_수 {

    public int solution(int n) {
        int answer = 0;
        int a = 1, b = 1;

        for (int i=2; i<n; i++){
            answer = (a + b) % 1234567;
            a=b;
            b=answer;
        }
        if (n==2) answer = b;

        return answer;
    }

}
