package inflearn.dfs_bfs_활용;

import java.util.*;
class Section8_unit1{
    static String answer="NO";
    static int n, total=0;
    boolean flag=false;
    public void DFS(int L, int sum, int[] arr){
        if(flag) return;

        if(sum > total/2 ) return; // 부분집합을 완성할 필요가 없음

        if(L==n){
            if((total-sum)==sum){
                answer="YES";
                flag=true;
            }
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args){
        Section8_unit1 T = new Section8_unit1();

        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();

        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
            total+=arr[i];
        }

        T.DFS(0, 0, arr);

        System.out.println(answer);
    }
}