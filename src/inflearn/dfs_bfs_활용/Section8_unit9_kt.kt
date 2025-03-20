package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit9_kt {
    private lateinit var combi: IntArray
    private var n = 0
    private var m = 0

    fun dfs(L: Int, s: Int) {
        if (L == m) {
            println(combi.joinToString(" "))
        } else {
            for (i in s..n) {
                combi[L] = i
                dfs(L + 1, i + 1)
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (nInput, mInput) = br.readLine().split(" ").map { it.toInt() }
        n = nInput
        m = mInput

        combi = IntArray(m) // 조합 배열

        dfs(0, 1) // (Level, start 번호)
    }
}

fun main() {
    Section8_unit9_kt().solve()
}