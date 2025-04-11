package baekjoon.string

import java.io.*

class BOJ_9251 {

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val m = br.readLine().toInt()
        val s = br.readLine()

        var i = 0
        var answer = 0

        while (i < m - 1) { // OOIOIOIOIIOII
            // IO 반복시작
            if (s[i] == 'I' && s[i + 1] == 'O') {
                var tmp = 0
                while (i + 2 < m && s[i + 1] == 'O' && s[i + 2] == 'I') {
                    tmp++
                    i += 2
                    if (tmp == n) {
                        answer++
                        tmp--
                    }
                }
                // 반복 끝 --.> 다음 문자 이동
                i++
            } else {
                i++
            }
        }

        println(answer)
    }
}

fun main() {
    BOJ_9251().solve()
}