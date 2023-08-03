package programmers.Lv2;
import java.util.*;
import java.io.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int lt = 0;
        int rt = people.length-1;
        Arrays.sort(people);

        int sum=0; // 무게 합
        while (lt <= rt){

            int min = people[lt]; // 몸무게 최소
            int max = people[rt]; // 몸무게 최대

            // 무게 제한보다 작거나 같은 경우
            if (min + max <= limit) {
                answer ++;
                lt++;
                rt--;
            }else{ // 무게 제한보다 큰 경우
                answer ++;
                rt--; // 무게가 제일 많이 나가는 사람 혼자
            }
        }

        return answer;
    }
}
