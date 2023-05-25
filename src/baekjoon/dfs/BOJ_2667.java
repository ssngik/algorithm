package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class BOJ_2667 {

    static int N, count;       // 지도의 크기, 단지의 수
    static int[][] map;        // 지도
    static boolean[][] visited;  // 방문여부 체크 배열
    static int[] house;       // 단지별 집의 수
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new int[N][N];                 // 지도
        visited = new boolean[N][N];         // 방문여부 체크 배열
        house = new int[N*N];            // 단지별 집의 수
        count = 0;                           // 단지의 수

        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    count++;
                    DFS(i, j);
                }
            } // J
        } // I


        Arrays.sort(house); // 오름차순 정렬

        System.out.println(count);
        for (int j : house) {
            if (j != 0) {
                System.out.println(j);
            }
        }


    }
    private static void DFS(int x, int y){
        visited[x][y] = true; // 방문 check
        house[count]++;       // 단지별 건물 수 증가

        for (int i = 0; i < 4; i++) {
            int dirX = x + dx[i];
            int dirY = y + dy[i];

            // 범위 초과시
            if (!indexCheck(dirX, dirY)) continue;

            // index Range OK, 방문하지 않았다면
            if (!visited[dirX][dirY] && map[dirX][dirY]==1){
                DFS(dirX, dirY);
            }

        }
    }

    // 방향벡터 이동시 index exception check
    private static boolean indexCheck(int dirX, int dirY){
        return (dirX >= 0 && dirY >= 0 && dirX < N && dirY < N);
    }

}
