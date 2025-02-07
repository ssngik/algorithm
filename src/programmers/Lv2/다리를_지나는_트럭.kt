package programmers.Lv2
import java.util.*

class 다리를_지나는_트럭 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList() // 트럭 관리 큐

        var bridgeWeight = 0 // 다리 위 트럭 총 무게
        var time = 0 //  경과 시간
        var index = 0 // 대기 트럭 index

        while (queue.isNotEmpty() || index < truck_weights.size) { // 다리 위 트럭이 있거나, 대기 트럭 있음
            time++

            // 다리를 빠져 나갈 시간이 된 트럭 제거
            if (queue.isNotEmpty() && queue.peek().second == time) {
                bridgeWeight -= queue.poll().first
            }


            // 새로운 트럭을 올릴 수 있는지
            if (index < truck_weights.size && bridgeWeight + truck_weights[index] <= weight) {
                queue.add(Pair(truck_weights[index], time + bridge_length)) // 트럭 추가, 나갈 시간 설정
                bridgeWeight += truck_weights[index] // 다리 무게 증가
                index++ // 다음 대기 트럭
            }
        }

        return time
    }
}