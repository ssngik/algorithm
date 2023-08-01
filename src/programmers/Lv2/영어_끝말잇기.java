package programmers.Lv2;

import java.util.ArrayList;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // answer[번호, 차례]
        ArrayList<String> arr = new ArrayList<>();

        arr.add(words[0]);

        // 번호 -> (i % n) + 1
        // 차례 -> (i / n) + 1
        for (int i=1; i<=words.length-1; i++){
            String now = words[i];

            // 중복 확인
            if (arr.contains(now)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            // 앞뒤 체크
            char beforeEnd = arr.get(i-1).charAt(arr.get(i-1).length()-1); // 이전 단어의 마지막 글자
            char nowStart = now.charAt(0); // 현재 단어의 첫 번째 글자

            // 끝말잇기가 틀린 경우
            if (beforeEnd != nowStart){
                answer[0] = (i % n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }

            // 단어 추가
            arr.add(now);
        }
        return answer;
    }
}
