package baekjoon.brute

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_1018 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val board = Array(n) { br.readLine() }
        var answer = Int.MAX_VALUE // 최소 다시 칠해야 하는 개수

        // 8 X 8
        for (i in 0..(n - 8)) {
            for (j in 0..(m - 8)) {
                // 최소 색칠 개수 계산
                answer = minOf(answer, countPaint(board, i, j))
            }
        }

        println(answer)

    }

    private fun countPaint(board: Array<String>, x: Int, y: Int): Int {
        val patterns = arrayOf("WBWBWBWB", "BWBWBWBW")
        var repaint1 = 0
        var repaint2 = 0

        // 다시 칠해야하는 개수
        for (i in 0 until 8) {
            for (j in 0 until 8) {
                val targetW = patterns[i % 2][j]  // 시작이 W인 경우
                val targetB = patterns[(i + 1) % 2][j]  // 시작이 B인 경우

                if (board[x + i][y + j] != targetW) repaint1++ //패턴 1과 e다른 경우
                if (board[x + i][y + j] != targetB) repaint2++ // 패턴 2와 다른 경우
            }
        }
        return minOf(repaint1, repaint2)
    }
}

fun main() {
    BOJ_1018().solve()
}