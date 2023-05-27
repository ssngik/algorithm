package inflearn.dfs_bfs_활용;

import java.util.*;
class Section8_unit7{
    int[][] dy = new int[35][35];

    public int DFS(int n, int r){

        if (dy[n][r]>0) return dy[n][r]; // 이미 구한 값인 경우 return

        if (n==r || r==0) return 1;
        else return dy[n][r]=DFS(n-1, r-1)+DFS(n-1, r); // 저장 후 Return
    }
    public static void main(String[] args){
        Section8_unit7 T = new Section8_unit7();

        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();

        // nCr
        System.out.println(T.DFS(n, r));
    }
}