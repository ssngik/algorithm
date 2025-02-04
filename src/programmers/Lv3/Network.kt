package programmers.Lv3
import java.util.*
class Network {
    lateinit var visited : BooleanArray
    lateinit var map : Array<MutableList<Int>>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        visited = BooleanArray(n + 1)
        map = Array(n + 1) { mutableListOf<Int>() }


        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j && computers[i][j] == 1) {
                    map[i + 1].add(j + 1)
                }
            }
        }

        for (i in 1..n) {
            if (!visited[i]) {
                bfs(i)
                answer++
            }
        }


        return answer
    }

    fun bfs(start: Int) {
        val queue : Queue<Int> = LinkedList()
        queue.add(start)

        visited[start] = true

        while(queue.isNotEmpty()) {
            val target = queue.poll()

            for (i in map[target]) {
                if (!visited[i]) {
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
    }
}