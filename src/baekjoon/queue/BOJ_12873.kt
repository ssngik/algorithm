package baekjoon.queue

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

class BOJ_12873 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val queue : Queue<Int> = LinkedList()
        val answer = mutableListOf<Int>()

        for (i in 1..N) { queue.offer(i) }

        while (queue.isNotEmpty()) {

            // 뒤로 이동
            repeat( K - 1) { queue.offer(queue.poll()) }

            answer.add(queue.poll())
        }

        println(answer.joinToString(", ", "<", ">"))

    }
}

fun main() {
    BOJ_12873().solve()
}