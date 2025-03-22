package inflearn.dfs_bfs_활용

import java.io.*
import java.util.*

data class MazePoint(val x: Int, val y: Int)

class Section8_unit11_kt {

    private val dx = intArrayOf(-1, 0, 1, 0) // 상, 우, 하, 좌
    private val dy = intArrayOf(0, 1, 0, -1)

    private val map = Array(7) { IntArray(7) } // 미로 정보
    private val dis = Array(7) { IntArray(7) } // 거리 정보

    fun bfs(x: Int, y: Int) {
        val q: Queue<MazePoint> = LinkedList()
        q.offer(MazePoint(x, y))
        map[x][y] = 1 // 방문 표시

        while (q.isNotEmpty()) {
            val tmp = q.poll()
            for (i in 0 until 4) {
                val nx = tmp.x + dx[i]
                val ny = tmp.y + dy[i]

                if (nx in 0..6 && ny in 0..6 && map[nx][ny] == 0) {
                    map[nx][ny] = 1
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1
                    q.offer(MazePoint(nx, ny))
                }
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        for (i in 0..6) {
            val row = br.readLine().split(" ").map { it.toInt() }
            for (j in 0..6) {
                map[i][j] = row[j]
            }
        }

        bfs(0, 0)

        val answer = dis[6][6]
        println(if (answer == 0) -1 else answer)
    }
}

fun main() {
    Section8_unit11_kt().solve()
}