package inflearn.dfs_bfs_활용;

import java.util.*;
class Section8_unit3{
    static int answer=Integer.MIN_VALUE, n, m;
    public void DFS (int L, int sum, int time, int[] ps, int[] pt){

        if (time > m) return; // 제한시간 m 을 넘어가면 끝냄

        if (L == n){ // 부분집합 완성
            answer=Math.max(answer, sum); // 최대값
        }
        else{
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt); // 문제를 푸는 경우, 시간 증가
            DFS(L+1, sum, time, ps, pt); // 풀지 않음 -> 시간 증가하지 않음
        }
    }

    public static void main(String[] args){
        Section8_unit3 T = new Section8_unit3();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt(); // 문제의 개수
        m=kb.nextInt(); // 제한 시간

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i=0; i<n; i++){
            a[i]=kb.nextInt();
            b[i]=kb.nextInt();
        }

        T.DFS(0, 0, 0, a, b);

        System.out.println(answer);
    }
}