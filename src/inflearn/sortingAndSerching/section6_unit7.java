package inflearn.sortingAndSerching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// comparable 인터페이스의 구현 클래스
class Point implements Comparable<Point>{
    public int x, y; // 좌표값
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    // Comparable 인터페이스를 통해서 정렬한다. 그때 정렬의 기준이 compareTo다. 이 정렬 기준에 의해 sort 가 정렬 해준다.

    // 정렬기준을 잡기 위한 재정의
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y-o.y; // 음수값 -> 오름차순
        else return this.x - o.x;
    }

}

public class section6_unit7 {
    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}
