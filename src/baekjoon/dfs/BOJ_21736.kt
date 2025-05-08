package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_21736 {
    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)

    private lateinit var campus : Array<CharArray>
    private lateinit var visited: Array<BooleanArray>
    private var cnt = 0
    private var N = 0
    private var M = 0
    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        N = n
        M = m

        campus = Array(N) { CharArray(M) }
        visited = Array(N) { BooleanArray(M) }

        var startX = 0 // 시작지점
        var startY = 0


        for (i in 0 until N) {
            val campusInfo = br.readLine()
            for (j in 0 until M) {
                campus[i][j] = campusInfo[j]
                if (campus[i][j] == 'I') {
                    startX = i
                    startY = j
                }
            }
        }

        dfs(startX, startY)

        if (cnt == 0) {
            println("TT")
        } else {
            println(cnt)
        }

    }

    private fun dfs(y: Int, x: Int) {
        visited[y][x] = true

        // 사람 만났을 때
        if (campus[y][x] == 'P') {
            cnt++
        }

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            if (ny in 0 until N && nx in 0 until M) {
                if (!visited[ny][nx] && campus[ny][nx] != 'X') {
                    dfs(ny, nx)
                }
            }
        }

    }
}

fun main() {
    BOJ_21736().solve()
}