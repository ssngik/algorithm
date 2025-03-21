package inflearn.dfs_bfs_활용

import java.io.BufferedReader
import java.io.InputStreamReader

class Section8_unit10_kt {

    private val arr = Array(8) { IntArray(8) }
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, -1, 0, 1)
    private var answer = 0

    fun dfs(x: Int, y: Int) {
        if (x == 7 && y == 7) {
            answer++
        } else {
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 1..7 && ny in 1..7 && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1
                    dfs(nx, ny)
                    arr[nx][ny] = 0 // 백트래킹
                }
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        for (i in 1..7) {
            val line = br.readLine().split(" ").map { it.toInt() }
            for (j in 1..7) {
                arr[i][j] = line[j - 1]
            }
        }
        arr[1][1] = 1 // 시작점 방문 처리
        dfs(1, 1)
        println(answer)
    }
}

fun main() {
    Section8_unit10_kt().solve()
}