package programmers.Lv2

import java.util.*

class 프로세스 {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue: Queue<Int> = LinkedList()

        priorities.sortedDescending().forEach {
            queue.add(it)
        }

        var answer = 0
        while (queue.isNotEmpty()) {
            for (i in priorities.indices) {
                if (priorities[i] == queue.peek()) {
                    queue.poll()
                    answer++
                    if (i == location) {
                        return answer
                    }
                }
            }
        }
        return answer
    }
}