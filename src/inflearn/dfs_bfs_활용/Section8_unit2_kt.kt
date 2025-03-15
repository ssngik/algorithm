package inflearn.dfs_bfs_활용

import java.io.BufferedReader
import java.io.InputStreamReader

class Section8_unit2_kt {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (C, N) = br.readLine().split(" ").map { it.toInt() }
        val weight = IntArray(N) { br.readLine().toInt() }
        var maxWeight = 0


        fun dfs(level: Int, sum: Int) {
            if (sum > C) return // 초과한 경우
            if (sum > maxWeight) maxWeight = sum // 최대 무게 업데이트
            if (level == N) return

            dfs(level + 1, sum + weight[level])
            dfs(level + 1, sum)
        }

        dfs(0, 0)
        println(maxWeight)
    }
}

fun main() {
    Section8_unit2_kt().solve()
}