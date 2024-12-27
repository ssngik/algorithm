package baekjoon.stack

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    repeat(n) {
        println(solve(br.readLine()))
    }
}

fun solve(input : String) : String{
    val stack = Stack<Char>()

    input.forEach {
        if (it == '(') stack.push(it)
        else if (stack.isEmpty()) return "NO"
        else stack.pop()
    }

    return if ( stack.isEmpty()) "YES"
    else "NO"
}