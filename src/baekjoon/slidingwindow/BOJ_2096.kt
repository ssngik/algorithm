package baekjoon.slidingwindow

import java.io.*

class BOJ_2002 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (g, s) = br.readLine().split(" ").map { it.toInt() } // W길이 g, S길이 s
        val W = br.readLine()
        val S = br.readLine()

        val freqW = IntArray(52) // W 문자 빈도
        val freqS = IntArray(52) // S 현재 윈도우 문자 빈도

        // 문자 인덱스
        fun getIndex(c: Char): Int {
            return if (c.isLowerCase()) c - 'a' else c - 'A' + 26
        }

        // W 문자 빈도
        for (c in W) freqW[getIndex(c)]++

        // 첫 g개 문자 빈독
        for (i in 0 until g) freqS[getIndex(S[i])]++

        var count = 0

        // 순열 포함 여부
        fun isValid(): Boolean = freqW.contentEquals(freqS)

        if (isValid()) count++

        // 슬라이딩 윈도우 진행
        for (i in g until s) {
            freqS[getIndex(S[i])]++ // 새로 추가되는 문자
            freqS[getIndex(S[i - g])]-- // 맨 앞 문자 제거

            if (isValid()) count++
        }

        println(count)
    }
}

fun main() {
    BOJ_2002().solve()
}

