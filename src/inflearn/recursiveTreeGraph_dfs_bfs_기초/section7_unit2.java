package inflearn.recursiveTreeGraph_dfs_bfs_기초;

import java.io.IOException;

// 10 진수 N 이 입력되면 2진수로 변환하여 출력하는 프로그램. (재귀함수 이용)

// D(1) - line 6 -> 1
// D(2) - line 6 -> 0
// D(5) - line 6 -> 1
// D(11) - line 6 -> 1
public class section7_unit2 {
    public void DFS(int n ){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.print(n%2+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        section7_unit2 T = new section7_unit2();
        T.DFS(11);
    }
}
