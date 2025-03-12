package baekjoon.stack

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_10799_KT {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val input = br.readLine()
        var answer = 0 // 잘린 쇠막대기 조각 개수
        val stack = ArrayDeque<Char>()

        for (i in input.indices) {
            if (input[i] == '(') {
                stack.addLast('(')
            } else {
                stack.removeLast() // 닫는 괄호
                if (input[i - 1] == '(') { // 이전 문자 : 여는 괄호 -> 레이저
                    answer += stack.size
                } else {
                    answer += 1 // 이전 문자 : 닫는 괄호 -> 끝 부분
                }
            }
        }
        println(answer)
    }
}

fun main() {
    BOJ_10799_KT().solve()
}