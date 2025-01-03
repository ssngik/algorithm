
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var m = 0
private var answer = 0 // 최대 음식물 크기

fun dfs(x: Int, y: Int): Int {
    visited[x][y] = true
    var count = 1

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 1) {
            count += dfs(nx, ny)
        }
    }

    return count
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(k) {
        val (r, c) = br.readLine().split(" ").map { it.toInt() - 1 }
        map[r][c] = 1
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j] && map[i][j] == 1) {
                answer = maxOf(answer, dfs(i, j))
            }
        }
    }

    println(answer)
}
