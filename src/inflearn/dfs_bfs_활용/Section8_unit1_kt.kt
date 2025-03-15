package inflearn.dfs_bfs_활용

import java.io.BufferedReader
import java.io.InputStreamReader

class Section8_unit1_kt {

    fun sovle() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        val total = arr.sum() // 입력 총 합
        var answer = "NO"
        var found = false

        fun dfs(level: Int, sum: Int) {
            if (found || sum > total / 2) return // 찾았거나 더 커져버린 경우
            if (level == N) {
                if (sum * 2 == total) {
                    answer = "YES"
                    found = true
                }
            } else {
                dfs(level + 1, sum + arr[level])
                dfs(level + 1, sum)
            }
        }

        dfs(0, 0)
        println(answer)
    }

}

fun main() {
    Section8_unit1_kt().sovle()
}