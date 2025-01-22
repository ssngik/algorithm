package programmers.Lv2

import java.util.*

class 기능개발 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        // progresses : 배포 순서대로 작업 진도
        // speeds : 개발 속도

        val queue : Queue<Int> = LinkedList()

        for (i in progresses.indices) {
            // 남은 작업
            val remain = 100 - progresses[i]

            // 배포일
            if (remain % speeds[i] == 0) queue.add(remain / speeds[i])
            else queue.add(remain / speeds[i] + 1)
        }

        var now = queue.poll()
        var cnt = 1 // 배포 개수

        while (queue.isNotEmpty()) {

            if (now >= queue.peek()) {
                cnt++
                queue.poll()
            } else {
                answer += cnt
                cnt = 1 // 배포 개수 초기화
                now = queue.poll()
            }
        }
        answer += cnt
        return answer
    }
}