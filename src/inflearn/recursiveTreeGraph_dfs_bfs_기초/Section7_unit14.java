package inflearn.recursiveTreeGraph_dfs_bfs_기초;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section7_unit14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v]=1; // 1 번에서 출발
        dis[v]=0; // 출발지점 0

        queue.offer(v);
        while (!queue.isEmpty()){
            int cv = queue.poll(); // 현재 지점
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){ // 방문 여부. nv 는 cv에서 이미 갈 수 있는 정점
                    if(ch[nv]==0){ // 방문 안했다면
                        ch[nv]=1; // 방문 check
                        queue.offer(nv);
                        dis[nv] = dis[cv]+1; // nv 는 cv에서 타고온 값
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Section7_unit14 T = new Section7_unit14();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 정점의 개수
        m = kb.nextInt(); // 간선의 개수
        graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1]; // 체크 배열
        dis = new int[n+1]; // distance 배열

        // 인접리스트 만들기
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1); // BFS 1번 정점부터 출발
        for (int i = 2; i <= n; i++) {
            System.out.println(i+ " : " + dis[i]);
        }
    }

}
