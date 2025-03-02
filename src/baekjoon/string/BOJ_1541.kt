package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_1541 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val sentence = br.readLine()
        val piece = sentence.split("-")

        var answer = piece[0].split("+").sumOf { it.toInt() } // 첫번째 덩어리 더하기


        for (i in 1 until piece.size) { // 두번째부터 괄호
            answer -= piece[i].split("+").sumOf { it.toInt() }
        }

        println(answer)

    }
}

fun main() {
    BOJ_1541().solve()
}