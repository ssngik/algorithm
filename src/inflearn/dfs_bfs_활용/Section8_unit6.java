package inflearn.dfs_bfs_활용;

import java.util.*;

public class Section8_unit6 {
    static int[] pm, ch, arr;
    static int N, M;
    public void DFS(int L){
        if (L==M){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for (int i = 0; i < N; i++) {
                if (ch[i]==0){
                    ch[i]=1; // 체크 걸기
                    pm[L] = arr[i];
                    DFS(L+1); // 체크 풀기
                    ch[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) {

        Section8_unit6 T = new Section8_unit6();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N]; // input 배열
        ch = new int[N]; // check 배열
        pm = new int[M]; // permutation 배열

        for(int i=0; i<N; i++) arr[i] = sc.nextInt();


        T.DFS(0);
    }
}
