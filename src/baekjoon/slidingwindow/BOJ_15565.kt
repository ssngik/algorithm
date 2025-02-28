package baekjoon.slidingwindow

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_15565 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (N, K) = br.readLine().split(" ").map { it.toInt() } // N : 인형, K : 최소 라이언
        val doll = br.readLine().split(" ").map { it.toInt() }

        var lp = 0
        var rp = 0
        var cnt = 0 // 라이언 개수
        var minLength = Int.MAX_VALUE // 최소 길이

        while (rp < N) {
            if (doll[rp] == 1) cnt++ // 라이언 발견

            while (cnt >= K) {
                minLength = minOf(minLength, rp - lp + 1)
                if (doll[lp] == 1) cnt--
                lp++
            }

            rp++
        }

        println(if (minLength == Int.MAX_VALUE) -1 else minLength)
    }
}

fun main() {
    BOJ_15565().solve()
}
