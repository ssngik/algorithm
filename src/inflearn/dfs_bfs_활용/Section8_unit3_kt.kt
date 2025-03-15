package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit3_kt {
    private var maxScore = 0
    private lateinit var scores: IntArray
    private lateinit var times: IntArray
    private var n = 0
    private var m = 0

    fun solve() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (nInput, mInput) = readLine().split(" ").map { it.toInt() }
        n = nInput
        m = mInput
        scores = IntArray(n)
        times = IntArray(n)

        for (i in 0 until n) {
            val (score, time) = readLine().split(" ").map { it.toInt() }
            scores[i] = score
            times[i] = time
        }

        dfs(0, 0, 0)
        println(maxScore)
    }

    private fun dfs(level: Int, totalScore: Int, totalTime: Int) {
        if (totalTime > m) return // 제한 시간 초과 - 종료
        if (totalScore > maxScore) maxScore = totalScore // 현재 점수가 최대 점수보다 큰 경우
        if (level == n) return // 모든 문제 확인한 경우

        dfs(level + 1, totalScore + scores[level], totalTime + times[level])
        dfs(level + 1, totalScore, totalTime)
    }
}

fun main() {
    Section8_unit3_kt().solve()
}