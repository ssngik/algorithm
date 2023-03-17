package inflearn.sortingAndSerching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순차 검색은 O(n)
// 이분 검색은 O(logN)

public class section6_unit8 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int answer = 0;
        int lt=0, rt=n-1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 정렬
        while (lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                System.out.println(mid+1);
                break;
            }
            if(arr[mid]>m) rt=mid-1;
            else lt = mid+1;
        }

    }
}
