package baekjoon.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_14940 {
    private var N = 0
    private var M = 0

    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)

    private lateinit var map: Array<IntArray>
    private lateinit var dist: Array<IntArray>

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        N = n
        M = m

        map = Array(N) { br.readLine().split(" ").map {  it.toInt() }.toIntArray() }
        dist = Array(N) { IntArray(M) { -1 } } // 거리 배열

        bfs()

        // 결과 출력
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 0) {
                    print("0 ")
                } else {
                    print("${dist[i][j]} ")
                }
            }
            println()
        }
    }

    private fun bfs() {
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        // 목표지점 찾기
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 2) {
                    queue.offer(Pair(i, j))
                    dist[i][j] = 0 // 목표지점 거리 -> 0
                }
            }
        }

        // bfs
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                // 유효 위치 && 방문하지 않은 땅 (1) 이동
                if (nx in 0 until N && ny in 0 until M && map[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1
                    queue.offer(Pair(nx, ny))
                }
            }
        }
    }

}

fun main() {
    BOJ_14940().solve()
}