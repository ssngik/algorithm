package baekjoon.queue

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

class BOJ_14713 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()

        val parrot = mutableListOf<Queue<String>>()

        repeat(N) {
            val sentence = LinkedList<String>()
            sentence.addAll(br.readLine().split(" "))
            parrot.add(sentence)
        }

        val lastSentence = br.readLine().split(" ")

        for (word in lastSentence) {
            var found = false
            for (queue in parrot) {
                if (queue.isNotEmpty() && queue.peek() == word) {
                    queue.poll()
                    found = true
                    break
                }
            }

            if (!found) {
                println("Impossible")
                return
            }
        }

        if (parrot.all { it.isEmpty()   }) {
            println("Possible")
        } else {
            println("Impossible")
        }

    }
}

fun main() {
    BOJ_14713().solve()
}