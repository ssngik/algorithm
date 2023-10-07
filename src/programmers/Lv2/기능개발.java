package programmers.Lv2;

import java.util.*;

class 기능개발 {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<progresses.length; i++){
            // 남은 진도율
            int remain = 100 - progresses[i];

            // 남은 배포 일
            if (remain % speeds[i] == 0) q.add(remain / speeds[i]);
            else q.add(remain / speeds[i] + 1);
        }
        System.out.print(q);
        int now = q.poll();
        int cnt = 1; // 배포 개수

        while(!q.isEmpty()){
            if (now >= q.peek()){
                cnt++; // 배포 가능 개수 증가
                q.poll();
            }else{
                answer.add(cnt);
                cnt=1; // 배포 개수 초기화
                now = q.poll();
            }
        }
        answer.add(cnt); // 마지막 작업

        return answer;
    }
}
