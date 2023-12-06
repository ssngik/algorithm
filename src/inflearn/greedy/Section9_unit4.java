package inflearn.greedy;

import java.io.*;
import java.util.*;
class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture ob){
        return ob.time-this.time; // 매개변수 - this -> 내림차순
    }
}

class Section9_unit4 {
    static int N, max=Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr){
        int answer=0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j=0;
        for(int i=max; i>=1; i--){ // 날짜가 하루씩 작아짐
            for(; j<N; j++){
                if(arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money); // 강연료 추가
            }
            if(!pQ.isEmpty()) answer += pQ.poll(); // 큐 안의(i 날짜의 강연 중 )가장 큰 값 (Collections.reverseOrder())
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        Section9_unit4 T = new Section9_unit4();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Lecture> arr = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr.add(new Lecture(m, d));

            if(d > max) max = d;
        }
        System.out.println(T.solution(arr));
    }
}