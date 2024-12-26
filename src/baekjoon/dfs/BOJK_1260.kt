package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

// BOJ_1260

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    // n -> 정점의 개수
    // m -> 간선의 개수
    // V -> 시작 정점 번호

    val adj = Array(n + 1) {IntArray(n+1)}
    var visited = ArrayList<Int>()

    repeat(m){
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        adj[x][y] = 1
        adj[y][x] = 1
    }

    dfs(v, adj, visited) // dfs 시작
    println()

    visited = ArrayList<Int>()  // 방문 정점 초기화
    bfs(v, adj, visited)  // bfs 시작
}

fun dfs(start: Int, adj: Array<IntArray>, visited : ArrayList<Int>) {
    visited.add(start)
    print("$start ")

    for (i in 1 until adj.size) {
        if (adj[start][i] == 1 && !visited.contains(i)) {
            dfs(i, adj, visited)
        }
    }
}

fun bfs(start: Int, adj: Array<IntArray>, visited: ArrayList<Int>) {
    val queue = LinkedList<Int>()
    queue.add(start)
    visited.add(start)

    while (queue.isNotEmpty()) {
        val t = queue.poll()
        print("$t ")

        for (i in 1 until adj.size) {
            if (adj[t][i] == 1 && !visited.contains(i)) {
                queue.add(i)
                visited.add(i)
            }
        }
    }
}