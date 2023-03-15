package inflearn.sortingAndSerching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class section6_unit6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 기존 순서\

        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] sort = arr.clone(); // 정렬한 순서
        Arrays.sort(sort);

        for(int i=0; i<n; i++) if(arr[i]!=sort[i]) answer.add(i+1);

        for(int x : answer) System.out.print(x + " ");

    }
}
