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

public class Section8_unit11 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, dis;

    static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        map[x][y]=1;

        while (!Q.isEmpty()){
            Point tmp = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                // index 범위, 도로 체크
                if (nx>=0 && nx<=6 && ny>=0 && ny<=6 && map[nx][ny]==0){

                    map[nx][ny] = 1; // 방문 체크
                    Q.offer(new Point(nx, ny));

                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 현재 지점 + 1
                }

            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[7][7];  // 미로
        dis = new int[7][7]; // 이동 거리


        for (int i=0; i<7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0, 0);

        if (dis[6][6]==0) System.out.println(-1); // 도착할 수 없는 경우
        else System.out.println(dis[6][6]);

    }
}
