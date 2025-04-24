package programmers.Lv3

class 순위 {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val graph = Array(n + 1) { IntArray(n + 1) }

        for ((win, lose) in results) { graph[win][lose] = 1 }

        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1 // i가 J를 이김
                    }
                }
            }
        }

        var answer = 0

        for (i in 1..n) {
            var winCnt = 0
            var loseCnt = 0

            for (j in 1..n) {
                if ( graph[i][j] == 1) winCnt++ // 이긴 경우
                if (graph[j][i] == 1) loseCnt++ // 진 경우
            }

            if (winCnt + loseCnt == n - 1) {  answer++  }
        }

        return answer
    }
}