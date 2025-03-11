package baekjoon.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_1325 {///

    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M) = br.readLine().split(" ").map { it.toInt() } // 컴퓨터 수 N 관계 수 M

        graph = Array(N + 1) { mutableListOf() }

        repeat(M) {
            val (A, B) = br.readLine().split(" ").map { it.toInt() }
            graph[B].add(A) // B가 해킹 -> A도 해킹
        }

        val result = IntArray(N + 1) // 해킹 가능한 수 d
        var maxCnt = 0 // 최대 해킹 가능 수

        for (i in 1..N) {
            visited = BooleanArray(N + 1)
            val cnt = bfs(i)
            result[i] = cnt
            maxCnt = maxOf(maxCnt, cnt)
        }

        val answer = mutableListOf<Int>()
        for (i in 1..N) {
            if (result[i] == maxCnt) { // 최대 해킹 가능한 컴퓨터 번호
                answer.add(i)
            }
        }

        println(answer.joinToString(" "))
    }

    private fun bfs(start: Int): Int {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        var count = 1 // 시작 노드

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            for (next in graph[current]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                    count++
                }
            }
        }

        return count // 총 해킹 가능 컴퓨터 수
    }
}

fun main() {
    BOJ_1325().solve()
}