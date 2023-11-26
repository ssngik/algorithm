package inflearn.greedy;

import java.io.*;
import java.util.*;

/*
* 14 s
18 e
12 s
15 e
15 s
20 e
20 s
* */
class Attend implements Comparable<Attend>{
    public int time; // 시간
    public char state; // 상태
    Attend(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Attend o){
        if (this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
public class Section9_unit3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Attend> arr =  new ArrayList<>();
        int N = Integer.parseInt(br.readLine()); // 피로연 참석 인원 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sT = Integer.parseInt(st.nextToken()); // 오는 시간
            int eT = Integer.parseInt(st.nextToken()); // 가는 시간(참석 시간에 포함 x)

            // time, State
            arr.add(new Attend(sT, 's'));
            arr.add(new Attend(eT, 'e'));
        }
        int answer = Integer.MIN_VALUE;

        Collections.sort(arr);
        int cnt = 0;

        for (Attend ob : arr){
            if (ob.state=='s') cnt++;
            else cnt--;

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }
}

