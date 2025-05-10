package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_24480 {
    private lateinit var graph : Array<MutableList<Int>>
    private lateinit var order : IntArray
    private lateinit var visited : BooleanArray
    private var cnt = 1
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M, R) = br.readLine().split(" ").map { it.toInt() } // 정점, 간선, 시작 정점

        graph = Array(N+1) { mutableListOf() }
        visited = BooleanArray(N+1)
        order = IntArray(N + 1)

        repeat(M) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        for (i in 1..N) {
            graph[i].sortDescending()
        }


        dfs(R)

        for (i in 1..N) {
            println(order[i])
        }
    }

    private fun dfs(node : Int) {
        visited[node] = true
        order[node] = cnt++

        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }
}

fun main() {
    BOJ_24480().solve()
}