package inflearn.dfs_bfs_활용;
import java.util.*;

class Section8_unit9{
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s){
        if(L==m){
            for(int x : combi) System.out.print(x+" ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args){
        Section8_unit9 T = new Section8_unit9();

        Scanner kb = new Scanner(System.in);
        n=kb.nextInt(); // n 개의 구슬 중
        m=kb.nextInt(); // m 개를 뽑음

        combi=new int[m];
        T.DFS(0, 1); // (Level, start 번호)
    }
}
