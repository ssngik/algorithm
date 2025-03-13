package baekjoon.bfs

import java.io.*
import java.util.*

class BOJ_11060 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()
        val map = br.readLine().split(" ").map { it.toInt() }
        val visited = IntArray(N) { -1 } // 방문 여부, 최소 점프 수
        val queue: Queue<Int> = LinkedList()

        visited[0] = 0 // 0번 시작
        queue.add(0)

        while (queue.isNotEmpty()) {
            val current = queue.poll() // 현재 위치
            val maxJump = map[current] // 점프 가능 최대 거리

            // 현재 위치에서 점프 가능한 범위 내
            for (next in (current + 1)..(current + maxJump).coerceAtMost(N - 1)) {
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1
                    queue.add(next)
                }
            }
        }

        println(visited[N - 1])
    }
}

fun main() {
    BOJ_11060().solve()
}
