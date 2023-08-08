package baekjoon.bfs;

import java.io.*;
import java.util.*;
// 1 -> 익은 토마토
// 0 -> 익지 않은 토마토
// -1 -> 토마토가 들어있지 않은 칸

class tomato{
    int x, y;
    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, days;
    static int N, M;
    static Queue<tomato> Q = new LinkedList<>();

    static int bfs(){

        while (!Q.isEmpty()){
            tomato tom = Q.poll();
            int x = tom.x;
            int y = tom.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 벗어난 경우

                if (map[nx][ny]==0){ // 익지 않은 토마토인 경우
                    map[nx][ny] = map[x][y] + 1; // 일수를 구하기 위해 이전 위치 + 1
                    Q.offer(new tomato(nx, ny)); // 익은 토마토 자리 추가
                }
            }
        }

        int answer = Integer.MIN_VALUE; // 토마토가 모두 익기 위한 최소 일수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 0 이 존재한다면 토마토가 모두 익지 못하는 상황 -> -1
                if (map[i][j] == 0){
                    return -1;
                }
                // 0이 아니라면 bfs를 돌며 계산된 일 수 중 가장 큰 수 -> 토마토 전체가 익기 위한 최소 일수
                else{
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }


        if (answer < 2) return 0; // 최소 하나 이상의 토마토가 주어짐 -> answer 가 2보다 작다면 최초 모두 익어있는 상태
        else return answer-1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수

        map = new int[N][M]; // 토마토 농장
        days = new int[N][M]; // 토마토가 익은 일수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토는 Queue에 저장
                if (map[i][j] == 1) Q.offer(new tomato(i, j));
            }
        }

        System.out.println(bfs());
    }
}

