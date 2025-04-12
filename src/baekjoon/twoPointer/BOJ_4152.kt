package baekjoon.twoPointer

import java.io.*

class BOJ_4152 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        while (true) {
            val (n, m) = br.readLine().split(" ").map { it.toInt() } //  상근, 선영이
            if (n == 0 && m == 0) break

            val sang = List(n) { br.readLine().toInt() }
            val sun = List(m) { br.readLine().toInt() }

            var i = 0
            var j = 0
            var cnt = 0

            while (i < n && j < m) {
                when {
                    sang[i] == sun[j] -> { // 공통 Cd 발견
                        cnt++
                        i++
                        j++
                    }
                    sang[i] < sun[j] -> i++ // 상근 cd가 선영보다 작음
                    else -> j++
                }
            }

            println(cnt)
        }

    }
}

fun main() { BOJ_4152().solve() }