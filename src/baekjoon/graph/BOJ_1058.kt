package baekjoon.graph

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_1058 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt() //    사람의 수

        val graph = Array(N) { IntArray(N) }

        for (i in 0 until N) {
            val friends = br.readLine()
            for (j in 0 until N) {
                graph[i][j] = if (friends[j] == 'Y') 1 else 0 // 친구 여부
            }
        }

        var max = 0

        for (i in 0 until N) {
            val visited = BooleanArray(N)

            for (j in 0 until N) {
                if (i == j) continue

                // 직접 친구
                if (graph[i][j] == 1) {
                    visited[j] = true
                } else {
                    for (k in 0 until N) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            visited[j] = true // 친구의 친구
                            break
                        }
                    }
                }
            }

            val friendCnt = visited.count { it }
            max = maxOf(max, friendCnt)
        }

        println(max)

    }
}

fun main() {
    BOJ_1058().solve()
}