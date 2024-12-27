package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().trim()
    if (input.isEmpty()) {
        println(0) // 공백만 입력된 경우
    } else {
        println(input.split(" ").size)
    }
}