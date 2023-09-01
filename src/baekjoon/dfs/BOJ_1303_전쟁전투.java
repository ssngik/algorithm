package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] answer = new int[2];
    static int count;

    static void dfs(int x, int y, char target){

        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || nx >= M || ny <0 || ny >= N) continue; // 범위 벗어난 경우
            if (map[nx][ny] != target) continue; // 병사가 다른 팀인 경우
            if (visited[nx][ny]) continue; // 이미 방문한 경우

            dfs(nx, ny, target);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기

        map = new char[M][N]; // 전쟁터
        visited = new boolean[M][N]; // 방문 체크

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){ // 방문하지 않았을 시
                    count=0; // 뭉친 병사의 수
                    char target = map[i][j]; // 현재 병사 소속 정보
                    dfs(i, j, target); // 탐색

                    // 흰색 -> 우리 팀, 출력 흰 파
                    if (map[i][j]=='W') answer[0] += count*count;
                    else answer[1] += count * count;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
