package inflearn.dfs_bfs_활용;

import java.util.*;
import java.io.*;

class Point{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class section8_unit12 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int N, M;
    static Queue<Point> Q = new LinkedList<>();
    static void bfs(){

        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny]==0){
                    board[nx][ny] = 1; // 방문
                    Q.offer(new Point(nx, ny)); // 새 탐색
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 현재 위치에서 + 1
                }

            }
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        board = new int[N][M]; // 토마토 농장
        dis = new int[N][M]; // 익은 날의 수

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) Q.offer(new Point(i, j)); // 익은 토마토 미리 넣기
            }
        }

        bfs(); // 탐색

        boolean flag = true; // 전체가 다 익을 수 있는지에 대한 여부
        int answer = Integer.MIN_VALUE; // 최대값 구하기

        // 토마토 전체가 익을 수 있는지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j]==0) flag = false;
            }
        }

        // 토마토 전체가 익을 수 있다면
        if (flag){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }else System.out.println(-1);

    }
}
