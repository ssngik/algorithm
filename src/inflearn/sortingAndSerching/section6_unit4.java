package inflearn.sortingAndSerching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class section6_unit4 {
    public int[] solution(int size, int[] arr){
        int[] cache = new int[size];

        for(int x : arr){
            int pos=-1; // 인덱스 위치
            for(int i=0; i<size; i++) if(x==cache[i]) pos=i; // hit -> hit 된 지점 저장
            if(pos==-1){ // miss
                for(int i=size-1; i>=1; i--){
                    cache[i]=cache[i-1];
                }
            }
            else{ // hit
                for(int i=pos; i>=1; i--){
                    cache[i]=cache[i-1];
                }

            }
            cache[0]=x;
        }


        return cache;
    }

    public static void main(String[] args) throws IOException {

        section6_unit4 T = new section6_unit4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        int s = Integer.parseInt(a[0]); // 캐시의 크기
        int n = Integer.parseInt(a[1]); // 작업의 개수
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int x : T.solution(s, arr)) System.out.print(x + " ");


    }
}
