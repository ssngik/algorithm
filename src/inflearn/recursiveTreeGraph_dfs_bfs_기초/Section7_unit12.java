package inflearn.recursiveTreeGraph_dfs_bfs_기초;
import java.util.*;

class Main {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i]==0){ // 현재 지점 ( v ) 에서 갈 수 있는 i 번 정점. ch[i] 가 0 이여야 갈 수 있음
                    ch[i]=1; // 방문 했으면 Check
                    DFS(i); // DFS(v) 가 i 가 되어야 함
                    ch[i]=0; // back 할 때 Check 풀기
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt(); // 노드의 개수
        m=kb.nextInt(); // 간선의 개수

        graph=new int[n+1][n+1]; // 1 ~ n 번 Index
        ch=new int[n+1]; // Check 배열

        for(int i=0; i<m; i++){ // 간선 개수만큼
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph[a][b]=1; // a -> b ( 방향 그래프 )
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}