package baekjoon.math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val xArr = mutableListOf<Int>()
    val yArr = mutableListOf<Int>()

    repeat(M) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        xArr.add(x)
        yArr.add(y)
    }

    // 정렬
    xArr.sort()
    yArr.sort()

    // 중앙값
    val xMedium = xArr[M/2]
    val yMedium = yArr[M/2]

    var answer = 0
    for (i in 0 until M) {
        answer += Math.abs(xArr[i] - xMedium) + Math.abs(yArr[i] - yMedium)
    }

    println(answer)
}