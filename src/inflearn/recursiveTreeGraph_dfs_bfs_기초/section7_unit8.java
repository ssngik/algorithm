package inflearn.recursiveTreeGraph_dfs_bfs_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class section7_unit8 {

    int answer=0; // 정답
    int[] dis={1, -1, 5}; // 이동
    int[] ch; // check 배열

    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e){

        ch = new int[10001]; // 체크 배열. 직선 좌표 1 ~ 10,000
        ch[s]=1; // 출발 지점
        Q.offer(s);

        int L=0; // 레벨
        while (!Q.isEmpty()){
            int len=Q.size(); // 레벨에 있는 원소의 개수

            for(int i=0; i<len; i++){
                int x= Q.poll();
                for(int j=0; j<3; j++){ // 세 방향
                    int nx=x+dis[j];
                    if(nx==e) return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0) {
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String[] args) {
        section7_unit8 T = new section7_unit8();
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt(); // 현수의 위치
        int E = sc.nextInt(); // 송아지의 위치

        System.out.println(T.BFS(S, E));

    }
}
