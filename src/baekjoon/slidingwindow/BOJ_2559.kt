package baekjoon.slidingwindow

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_2559 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        // 전체 날자, 연속적인 일수
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val temperature = br.readLine().split(" ").map { it.toInt() } // 온도 측정값

        var sum = temperature.take(K).sum() // 초기 윈도우 합

        var max = sum //  최대 합


        for (i in K until N) {
            sum += temperature[i] - temperature[i - K]
            max = maxOf(max, sum)
        }

        println(max)
    }
}

fun main() {
    BOJ_2559().solve()
}