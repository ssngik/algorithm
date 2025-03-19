package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit4_kt {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val result = mutableListOf<Int>()
        val sb = StringBuilder()

        fun dfs(depth: Int) {
            if (depth == M) { // M개 선택시 출력
                sb.append(result.joinToString(" ")).append("\n")
                return
            }

            for (i in 1..N) {
                result.add(i)
                dfs(depth + 1)
                result.removeAt(result.size - 1)
            }
        }

        dfs(0)
        print(sb.toString())
    }
}

fun main() {
    Section8_unit4_kt().solve()
}