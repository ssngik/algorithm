package softeer.Lv2;

import java.util.*;
import java.io.*;

public class 장애물_인식_프로그램
{
    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1,0, -1};

    static int[][] map, visited;
    static int count=0;
    static int N;
    static ArrayList<Integer> answer = new ArrayList<>();

    static void dfs(int x, int y){
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위가 초과되는 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            // 이미 방문한 경우
            if (visited[nx][ny]==1) continue;

            // 다음 방문할 곳이 도로인 경우
            if (map[nx][ny] == 0) continue;

            count++; // 장애물의 수

            visited[nx][ny] = 1; // 방문 체크
            dfs(nx, ny);
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 총 블록의 수

        map = new int[N][N];
        visited = new int[N][N];

        for (int i=0; i<N; i++){
            String input = br.readLine();
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (visited[i][j]==0 && map[i][j]==1){
                    visited[i][j] = 1; // 방문 체크
                    count++; // 장애물의 수

                    dfs(i, j);

                    answer.add(count);
                    count = 0;
                }
            }
        }

        int size = answer.size();
        System.out.println(size); // 장애물 블록 개수 출력

        Collections.sort(answer); // 오름차순 정렬

        for (int i=0; i<size; i++) System.out.println(answer.get(i)); // 각 장애물 개수 출력

    }
}