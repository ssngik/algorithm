package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_10026 {

    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)

    private var N = 0
    private lateinit var map: Array<CharArray>
    private lateinit var visited: Array<BooleanArray>

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        N = br.readLine().toInt()
        map = Array(N) { br.readLine().toCharArray() }


        // 적록색약 아닌 사람
        visited = Array(N) { BooleanArray(N) { false } }
        var count = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (!visited[i][j]) { // 탐색 가능한 부분
                    dfs(i, j, map[i][j], false)
                    count++
                }
            }
        }

        visited = Array(N) { BooleanArray(N) { false } } // 방문 배열 초기화
        var rgBlindCount = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j], true) // 적록색약 O
                    rgBlindCount++
                }
            }
        }

        println("$count $rgBlindCount")
    } // solve

    private fun dfs(x: Int, y: Int, color: Char, isRGBlind: Boolean) {
        visited[x][y] = true

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until N && ny in 0 until N && !visited[nx][ny]) {
                // 적록색약이 아닌 경우
                if (!isRGBlind && map[nx][ny] == color) {
                    dfs(nx, ny, color, isRGBlind)
                }
                // 적록색약인 경우
                else if (isRGBlind && ((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G'))
                    || color == 'B' && map[nx][ny] == 'B') {
                    dfs(nx, ny, color, isRGBlind)
                }
            }
        }
    }
}

fun main() {
    BOJ_10026().solve()
}