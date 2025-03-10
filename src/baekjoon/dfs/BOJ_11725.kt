package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_11725 {
    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var parent: IntArray
    private lateinit var visited: BooleanArray

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()

        graph = Array(N + 1) { mutableListOf() }
        parent = IntArray(N + 1)
        visited = BooleanArray(N + 1)

        repeat(N - 1) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        dfs(1) // 루트 노드 1

        val sb = StringBuilder()
        for (i in 2..N) {
            sb.append("${parent[i]}\n")
        }
        print(sb)
    }

    private fun dfs(node: Int) {
        visited[node] = true
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                parent[neighbor] = node // 현재 노드가 부모
                dfs(neighbor) // 다음 노드
            }
        }
    }
}

fun main() {
    BOJ_11725().solve()
}