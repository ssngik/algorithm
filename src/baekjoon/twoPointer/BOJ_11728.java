// https://www.acmicpc.net/problem/11728
package baekjoon.twoPointer;

import java.io.*;
import java.util.ArrayList;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // A 배열의 크기
        int m = Integer.parseInt(input[1]); // B 배열의 크기
        ArrayList<Integer> answer = new ArrayList<>();

        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");

        int p1=0, p2=0;

        while (p1<n && p2<m){
            if(Integer.parseInt(arrA[p1])<Integer.parseInt(arrB[p2])) answer.add(Integer.parseInt(arrA[p1++]));
            else answer.add(Integer.parseInt(arrB[p2++]));
        }
        // 나머지 숫자 정리
        while(p1<n) answer.add(Integer.parseInt(arrA[p1++]));
        while(p2<m) answer.add(Integer.parseInt(arrB[p2++]));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int x : answer) bw.write(x + " ");
        bw.flush();

    }
}
