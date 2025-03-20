package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit7_kt {
    private val dy = Array(35) { IntArray(35) }

    fun dfs(n: Int, r: Int): Int {
        if (dy[n][r] > 0) return dy[n][r] // 이미 구한 값인 경우
        if (n == r || r == 0) return 1 // 종료 조건 (모두 선택 or 선택 x)

        dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r) // 점화식 적용
        return dy[n][r]
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, r) = br.readLine().split(" ").map { it.toInt() }

        println(dfs(n, r)) // nCr
    }
}

fun main() {
    Section8_unit7_kt().solve()
}