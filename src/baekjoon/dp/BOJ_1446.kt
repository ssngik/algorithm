package baekjoon.dp

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_1446 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, d) = br.readLine().split(" ").map { it.toInt() } // 지름길 개수, 고속도로 길이


        val shortCut = mutableListOf<Triple<Int, Int, Int>>() // 지름길 정보

        repeat(n) {// 시작, 도착, 지름길 길이
            val (start, end, dist) = br.readLine().split(" ").map { it.toInt() }

            // 도착 지점이 길이 초과 혹은, 지름길이 손해면 무시
            if (end - start > dist && end <= d) {
                shortCut.add(Triple(start, end, dist))
            }
        }

        // i까지 최소거리
        val dp = IntArray(d + 1) { it }

        for (i in 0..d) {
            if (i > 0) dp[i] = minOf(dp[i], dp[i - 1] + 1) // 한 칸 이동

            // 도착 지점 갱신
            for ((start, end, dist) in shortCut) {
                if (start == i) {
                    dp[end] = minOf(dp[end], dp[start] + dist)
                }
            }
        }

        print(dp[d])
    }
}

fun main() { BOJ_1446().solve() }