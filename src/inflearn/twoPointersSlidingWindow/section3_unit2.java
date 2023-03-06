package inflearn.twoPointersSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class section3_unit2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // A 크기
        int[] a = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine()); // B 크기
        int[] b = new int[m];
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input2[i]);
        }

        int p1=0, p2=0;
        Arrays.sort(a); // 정렬
        Arrays.sort(b); // 정렬

        ArrayList<Integer> answer = new ArrayList<>();

        while(p1 < n && p2 < m){

            if(a[p1]==b[p2]){
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1]<b[p2]) p1++;
            else p2++;
        }

        for(int x : answer) System.out.print(x + " ");
    }
}
