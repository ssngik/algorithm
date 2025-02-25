package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_13023 {

    lateinit var graph: Array<MutableList<Int>> // 친구 관계 인접 리스트
    lateinit var visited: BooleanArray
    var answer = 0

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(N) { mutableListOf<Int>() }
        visited = BooleanArray(N)

        repeat(M) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        for (i in 0 until N) {
            dfs(i, 1)
            if (answer == 1) break
        }

        println(answer)
    }

    private fun dfs(node: Int, depth: Int) {
        if (depth == 5 || answer == 1) {
            answer = 1
            return
        }

        visited[node] = true
        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1)
            }
        }
        visited[node] = false
    }

}

fun main() {
    BOJ_13023().solve()
}