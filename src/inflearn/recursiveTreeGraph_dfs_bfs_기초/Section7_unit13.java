package inflearn.recursiveTreeGraph_dfs_bfs_기초;
// Section7_unit13_경로탐색(인접리스트, ArrayList)

import java.util.*;
class Main {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph; // 그래프 선언
    static int[] ch; // check 배열
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){ // v번 ArrayList
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();

        // Input
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();

        // 0 ~ 5 번까지 객체 생성, 0은 버림
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        ch=new int[n+1];

        // ArrayList 에 데이터 넣기
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }

        ch[1]=1; // 체크
        T.DFS(1);
        System.out.println(answer);
    }
}