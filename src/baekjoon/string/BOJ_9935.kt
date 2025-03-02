package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_9935 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val input = br.readLine() // 전체 문자열
        val bomb = br.readLine() // 폭발 문자열
        val stack = mutableListOf<Char>()

        for (char in input) {
            stack.add(char)

            if (stack.size >= bomb.length && stack.takeLast(bomb.length).joinToString("") == bomb){
                repeat(bomb.length) { stack.removeAt(stack.size - 1 )} // 폭발 문자열 삭제
            }
        }

        if ( stack.isEmpty() ) {
            println("FRULA")
        } else {
            println(stack.joinToString(""))
        }

    }
}

fun main() {
    BOJ_9935().solve()
}