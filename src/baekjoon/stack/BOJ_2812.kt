package baekjoon.stack

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_2812 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`)) // n자리 숫자, k : 제거할 숫자 개수
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val number = br.readLine()
        val stack = ArrayDeque<Char>()
        var cnt = k

        for (num in number) {
            while (stack.isNotEmpty() && cnt > 0 && stack.last() < num) {
                stack.removeLast()
                cnt-- // 제거한 숫자 개수 감소
            }
            stack.addLast(num)
        }

        // 제거할 숫자가 남아있는 경우
        repeat(cnt) { stack.removeLast() }

        println(stack.joinToString(""))
    }
}

fun main() {
    BOJ_2812().solve()
}