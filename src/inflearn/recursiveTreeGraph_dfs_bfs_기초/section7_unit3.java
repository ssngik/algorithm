package inflearn.recursiveTreeGraph_dfs_bfs_기초;

import java.io.IOException;

// 자연수 N 이 입력되면 N! 을 구하라

// DFS(5)

//          1
// 2 * DFS(1)
// 3 * DFS(2)
// 4 * DFS(3)
// 5 * DFS(4)

public class section7_unit3 {
    public int DFS(int n){
        if(n==1) return 1;
        else return n * DFS(n-1);
    }
    public static void main(String[] args) throws IOException {
        section7_unit3 T = new section7_unit3();
        System.out.println(T.DFS(5));

    }
}
