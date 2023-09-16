package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time implements Comparable<Time>{
    public int s, e; // 시작, 끝
    Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        if (this.e == o.e)return this.s - o.s; // 끝나는 시간이 같으면 시작 시간에 의해 오름차순
        else return this.e - o.e; // 다르면 끝나는 시간에 의해 정렬
    }
}
public class Section9_unit2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Time> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken()); // 회의의 수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Time(x, y));
        }

        int cnt = 0;
        Collections.sort(arr);
        int et = 0;
        for(Time ob : arr){
            if (ob.s >= et){ // 회의 가능
                cnt++;
                et= ob.e; // End time 교체
            }
        }

        System.out.println(cnt);
    }
}
