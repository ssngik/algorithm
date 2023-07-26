package programmers.Lv2;

public class 다음_큰_숫자 {

    public int solution(int n) {
        int answer = 0;

        String biNum = Integer.toBinaryString(n); // n 의 2진수
        int target = biNum.replace("0", "").length(); // n 의 2진수에서 1의 갯수
        while(true){

            n++; // 다음 큰 수를 위해
            String nextBiNum = Integer.toBinaryString(n); // 다음 큰 수의 2진수
            int nextTarget = nextBiNum.replace("0", "").length(); // 다음 큰 수의 2진수에서 1의 갯수

            if (target == nextTarget){
                answer = n;
                break;
            }
        }

        return answer;
    }
}
