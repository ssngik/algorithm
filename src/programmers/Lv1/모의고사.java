package programmers.Lv1;

import java.util.*;
class 모의고사 {
    public ArrayList solution(int[] answers) {
        // 맞힌 문제 수 저장 배열
        int[] arr = new int[3];

        // 정답
        ArrayList<Integer> answer = new ArrayList<>();

        // 문제 푸는 패턴
        int[][] pattern =
                {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

        // 최대 정답 수
        int max = 0;

        // 정답 저장 -> 각 수포자 순서
        for (int i=0; i<3; i++){
            // 문제 맞힌 개수 초기화
            int cnt = 0;

            // 문제 푸는 패턴의 길이
            int N = pattern[i].length;

            // 문제를 맞힌 경우
            for (int j=0; j<answers.length; j++){
                if (answers[j] == pattern[i][j%N]) cnt++;
            }

            // 맞힌 정답 저장
            arr[i] = cnt;

            // 최대 정답 수 저장
            if (max <= cnt) max = cnt;
        }

        // 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
        for (int i=0; i<3; i++){
            if (arr[i] == max) answer.add(i+1);
        }

        return answer;
    }
}