package baekjoon.bfs

import java.io.*
import java.util.*

class BOJ_4963_kt {

    // 대각선 포함 방향 벡터 /
    private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

    private var w = 0
    private var h = 0
    private lateinit var map: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        while (true) {
            val (width, height) = br.readLine().split(" ").map { it.toInt() }
            w = width
            h = height
            if (w == 0 && h == 0) break // 0 0 입력 시 종료

            // 지도, 방문 배열 초기화
            map = Array(h) { IntArray(w) }
            visited = Array(h) { BooleanArray(w) }

            repeat(h) { i ->
                map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            var cnt = 0 // 섬 개수 cnt
            for (i in 0 until h) {
                for (j in 0 until w) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j)
                        cnt++
                    }
                }
            }
            println(cnt)
        }
    }

    private fun bfs(x: Int, y: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(x, y))
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val (cx, cy) = queue.poll() // 현재 위치

            for (i in dx.indices) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                // 범위 안, 땅, 아직 방문 안 한 경우
                if (nx in 0 until h && ny in 0 until w && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.offer(Pair(nx, ny))
                }
            }
        }
    }
}

fun main() {
    BOJ_4963_kt().solve()
}
