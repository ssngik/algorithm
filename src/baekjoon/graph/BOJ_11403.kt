package baekjoon.graph

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_11403 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()
        val graph = Array(N) { IntArray(N) }

        for (i in 0 until N) {
            graph[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        // i, k -> k, j -> i , j
        for (k in 0 until N) {  // 중간
            for (i in 0 until N) {  // 시작
                for (j in 0 until N) {  // 도착
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1
                    }
                }
            }
        }

        for (i in 0 until N) {
            println(graph[i].joinToString(" "))
        }

    }
}

fun main() {
    BOJ_11403().solve()
}