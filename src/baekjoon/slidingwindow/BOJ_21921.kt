package baekjoon.slidingwindow

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_21921 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, X) = br.readLine().split(" ").map { it.toInt() }
        val visitor = br.readLine().split(" ").map { it.toInt() }

        var current = visitor.take(X).sum()
        var maxSum = current // 최대 방문자 수
        var count = 1

        for (i in X until N) {
            current += visitor[i] - visitor[i - X]
            when {
                current > maxSum -> {
                    maxSum = current
                    count = 1
                }
                current == maxSum -> count++
            }
        }

        if (maxSum == 0) { // 최대 방문자 수 0
            println("SAD")
        } else {
            println(maxSum)
            println(count)
        }
    }
}

fun main() {
    BOJ_21921().solve()
}