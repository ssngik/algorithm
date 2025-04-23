package programmers.Lv3

import java.util.*

class 가장먼노드 {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in edge) {
            graph[a].add(b)
            graph[b].add(a)
        }

        // 거리 저장
        val dist = IntArray(n + 1) { -1 }


        val queue: Queue<Int> = LinkedList()
        queue.add(1)

        dist[1] = 0  // 시작 노드 거리 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (neighbor in graph[current]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1
                    queue.add(neighbor)
                }
            }
        }

        val max = dist.maxOrNull() ?: 0
        return dist.count { it == max }
    }
}