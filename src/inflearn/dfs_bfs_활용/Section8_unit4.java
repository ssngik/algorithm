package inflearn.dfs_bfs_활용;

import java.io.*;
import java.util.*;

public class Section8_unit4 {

    static int[] pm;
    static int N, M;
    public void DFS(int L){
        if(L==M){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=1; i<=N ; i++){
                pm[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Section8_unit4 T = new Section8_unit4();

        N = Integer.parseInt(input[0]); // 구슬 번호
        M = Integer.parseInt(input[1]); // 중복 허용 횟수
        pm = new int[M];


        T.DFS(0);
    }
}
