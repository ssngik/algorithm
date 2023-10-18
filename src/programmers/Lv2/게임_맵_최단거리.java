package programmers.Lv2;

import java.util.*;

class 게임_맵_최단거리 {
    // 방향 벡터
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int N, M;

    public int solution(int[][] maps) {
        int answer = 0;

        N = maps.length;
        M = maps[0].length;

        boolean[][] visited = new boolean[N][M];

        bfs(maps, visited);

        // 최종 도착 지점
        answer = maps[N-1][M-1];

        // 최종 도착 지점에 도달하지 못 한 경우(초기값 1)
        if (answer == 1) return -1;

        return answer;
    }

    public void bfs(int[][] maps, boolean[][] visited){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        while(!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i=0; i<4; i++){
                // 다음 방향 좌표
                int nx = x + dx[i];
                int ny = y + dy[i];

                // index 범위 벗어난 경우
                if (nx<0 || nx >= N || ny < 0 || ny >= M) continue;

                // 갈 수 있는 길이 아닌 경우
                if (maps[nx][ny] == 0) continue;

                // 이미 방문한 경우
                if (visited[nx][ny]) continue;

                // 조건 만족 //

                // 방문 체크
                visited[nx][ny] = true;

                // 방문 거리 증가
                maps[nx][ny] = maps[x][y] + 1;

                // 큐 추가
                q.add(new Point(nx, ny));

            } // for
        } // wh
    }

    // 좌표
    class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}