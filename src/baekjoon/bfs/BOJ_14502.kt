package baekjoon.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_14502 {
    private var N = 0
    private var M = 0
    private lateinit var map: Array<IntArray>
    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)
    private var answer = 0

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        N = n
        M = m
        map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

        putWall(0)

        println(answer)
    }

    // 벽을 3개 세우는 모든 경ㅇ
    private fun putWall(cnt : Int) {
        if (cnt == 3) {
            // 3개 벽을 세운 경우
            answer = maxOf(answer, virusSpread())
            return
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 0) {
                    map[i][j] = 1
                    putWall(cnt + 1)
                    map[i][j] = 0 // 백트래킹
                }
            }
        }
    }

    // 바이러스 확산, 안전 영역 계산
    private fun virusSpread() : Int {
        val tempMap = Array(N) { i -> map[i].clone() }
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (tempMap[i][j] == 2) {
                    queue.offer(Pair(i, j))
                }
            }
        }

        // 바이러스 확산
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until N && ny in 0 until M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2
                    queue.offer(Pair(nx, ny))
                }
            }
        }

        // 안전 영역 계산
        return tempMap.sumOf { row -> row.count { it == 0 } }
    }
}

fun main() {
    BOJ_14502().solve()
}