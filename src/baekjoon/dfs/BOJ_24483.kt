package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_24483 {
    private lateinit var graph : Array<MutableList<Int>>
    private lateinit var visited : BooleanArray
    private lateinit var depth : IntArray
    private lateinit var order : IntArray
    private var cnt = 1
    fun sovle() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M, R) = br.readLine().split(" ").map { it.toInt() }

        graph = Array(N + 1) { mutableListOf() }
        visited = BooleanArray(N + 1)
        depth = IntArray( N + 1) { -1 }
        order = IntArray( N + 1)

        repeat (M) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        for (i in 1..N) {
            graph[i].sort()
        }

        dfs(R, 0)

        var answer: Long = 0

        for (i in 1..N) {
            answer += depth[i].toLong() * order[i]
        }

        println(answer)
    }

    private fun dfs(node: Int, d : Int) {
        visited[node] = true
        depth[node] = d
        order[node] = cnt++

        for (i in graph[node]) {
            if (!visited[i]) {
                dfs(i, d + 1)
            }
        }
    }
}

fun main() {
    BOJ_24483().sovle()
}