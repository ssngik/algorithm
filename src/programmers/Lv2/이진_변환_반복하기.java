package programmers.Lv2;


public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        // s가 1이 되면 종료
        while(!s.equals("1")){

            int oneCnt=0;

            // 0이 제거된 횟수
            for (int i=0; i<s.length(); i++){
                if (s.charAt(i)=='0'){
                    answer[1]++;
                }else{
                    // 변환할 길이
                    oneCnt++;
                }
            }

            // 이진 변환
            s = Integer.toBinaryString(oneCnt);
            answer[0]++;
        }


        return answer;
    }
}
