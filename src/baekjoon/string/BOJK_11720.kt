package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val num = br.readLine()

    var sum = 0
    num.forEach {
        sum += it.digitToInt()
    }

    println(sum)
}