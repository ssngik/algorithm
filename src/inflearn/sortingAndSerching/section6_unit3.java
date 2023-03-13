package inflearn.sortingAndSerching;

import java.util.Scanner;

public class section6_unit3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        for(int i=1; i<n; i++){
            int tmp=arr[i], j; // j 의 scope 때문
            for(j=i-1; j>=0; j--){
                if(arr[j]>tmp) arr[j+1]=arr[j]; // 뒤로 밀기
                else break;
            }
            arr[j+1]=tmp; // j 가 멈춘 지점 + 1
        }
        for(int i=0; i<n; i++) System.out.print(arr[i] + " ");
    }
}
