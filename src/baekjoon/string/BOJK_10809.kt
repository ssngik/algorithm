package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = br.readLine()
    val position = IntArray(26) { - 1 }

    for (i in s.indices) {
        val charIndex = s[i] - 'a'
        if (position[charIndex] == -1) {
            position[charIndex] = i
        }
    }

    println(position.joinToString(" "))

}