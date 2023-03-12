package inflearn.stack_queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id; // 환자 id
    int priority; // 환자의 위험도 ( 우선순위)
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}

public class section5_unit8 {

    public int solution(int N, int M, int[] arr){
        int answer = 0;

        Queue<Person> queue = new LinkedList<>(); // 환자 목록을 위한 Queue

        for(int i =0; i<N; i++) queue.offer(new Person(i, arr[i])); // 환자의 id 와 우선순위 offer

        while (!queue.isEmpty()){
            Person tmp = queue.poll(); // 젤 첫 번째 환자 뽑아내기

            for(Person x : queue){ // 전체 환자를 대상으로 탐색
                if(x.priority > tmp.priority){ // // 다음 순서 환자들 중 우선순위가 더 높은 환자가 있다면
                    queue.offer(tmp); // 제일 뒤로 보내기
                    tmp = null; // tmp 비워주기
                    break;
                }
            }
            if(tmp!=null){ // if 문에서 걸러지지 않음. 즉, 이 환자가 정답.
                answer++; // 진료 받은 환자는 증가.
                if(tmp.id==M) return answer; // 찾고자 하는 환자와 tmp 의 id가 같다면
            }

        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        section5_unit8 T = new section5_unit8();

        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt(); // 환자의 수
        int M = kb.nextInt(); // 순서가 궁금한 환자
        int[] arr = new int[N]; // 환자 목록을 위한 배열

        for (int i = 0; i <N; i++) arr[i] = kb.nextInt(); // N 명의 환자 id 입력 받기

        System.out.println(T.solution(N, M, arr));

    }
}