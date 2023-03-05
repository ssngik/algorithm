package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class section3_unit1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] input = br.readLine().split(" ");

        // 첫 번째 배열 입력
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(input[i]);

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        String[] input2 = br.readLine().split(" ");

        // 두 번째 배열 입력
        for(int i=0; i<m; i++) b[i] = Integer.parseInt(input2[i]);

        // 정답
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 =0;
        while (p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);

        for(int x : answer) System.out.print(x + " ");
    }
}
