package inflearn.dfs_bfs_활용;

import java.util.*;
class Section8_unit2{
    static int answer=Integer.MIN_VALUE, c, n;
    public void DFS(int L, int sum, int[] arr){
        if(sum > c) return; // C 무게 넘게 태울 수 없음

        // Sum 이 C 보다 작거나 같음
        if(L == n){
            answer=Math.max(answer, sum);
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args){
        Section8_unit2 T = new Section8_unit2();
        Scanner kb = new Scanner(System.in);

        c=kb.nextInt(); // 무게
        n=kb.nextInt(); // 바둑이 마리수

        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }

        T.DFS(0, 0, arr);

        System.out.println(answer);
    }
}