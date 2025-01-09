package programmers.Lv3

class TravelRouteSolution {
    lateinit var visited : BooleanArray
    val answer = mutableListOf<String>()


    fun solution(tickets: Array<Array<String>>): Array<String> {
        visited = BooleanArray(tickets.size)

        tickets.sortWith(compareBy({ it[0] }, { it[1] }))

        dfs("ICN", tickets, 0)

        return answer.toTypedArray()
    }

    private fun dfs(current: String, tickets: Array<Array<String>>, count: Int) : Boolean {
        if (count == tickets.size) { // 모든 티켓을 사용한 경우
            answer.add(current) // 현재 공항 추가
            return true
        }



        for (i in tickets.indices) {
            if (!visited[i] && tickets[i][0] == current) {
                visited[i] = true // 항공권 사용
                answer.add(current) // 현재 공항 추가

                // 다음 공항 이동
                if (dfs(tickets[i][1], tickets, count +1)) {
                    return true
                }

                // 백트래킹
                visited[i] = false
                answer.removeAt(answer.lastIndex)
            }
        }
        return false
    }
}