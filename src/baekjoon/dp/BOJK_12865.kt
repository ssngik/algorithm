package baekjoon.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, K) = br.readLine().split(" ").map { it.toInt() } // 물품 수, 최대 무게

    // 물건 정보 입력
    val items = List(n) {
        val (W, V) = br.readLine().split(" ").map { it.toInt() }
        W to V // 무게, 가치
    }

    val dp = IntArray(K + 1)

    // DP 갱신
    for ((W, V) in items) { // 각 물건 (물건 무게, 가치)
        for (k in K downTo W) { // 역순 dp 갱신,
            dp[k] = maxOf(dp[k], dp[k - W] + V) // 넣는 경우, 넣지 않은 경우
        }
    }

    println(dp[K])
}