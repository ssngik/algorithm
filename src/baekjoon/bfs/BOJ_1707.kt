package baekjoon.bfs

import java.io.*
import java.util.*

fun bfs(start: Int, graph: Array<MutableList<Int>>, color: IntArray): Boolean {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    color[start] = 0 // 시작 노드 그룹 0

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (neighbor in graph[node]) {
            if (color[neighbor] == -1) {
                color[neighbor] = 1 - color[node] // 반대색 칠하기
                queue.add(neighbor)
            } else if (color[neighbor] == color[node]) return false
        }
    }

    return true
}

// BOJ_1707_이분그래프
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt() // tc

    repeat(T) {
        val (V, E) = br.readLine().split(" ").map { it.toInt() } // 정점 간선 개수
        val graph = Array(V + 1) { mutableListOf<Int>() }
        val color = IntArray(V + 1) { -1 } // -1 - 미방문, 0 - 파랑, 1 - 빨강

        repeat(E) {
            val (v, e) = br.readLine().split(" ").map { it.toInt() } // 정점 간선 개수
            graph[v].add(e)
            graph[e].add(v)
        }

        var isBipartite = true
        for (i in 1..V) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color)) {
                    isBipartite = false
                    break
                }
            }
        }

        println(if (isBipartite) "YES" else "NO")
    }
 }