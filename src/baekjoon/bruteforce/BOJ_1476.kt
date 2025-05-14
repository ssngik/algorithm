package baekjoon.bruteforce

class BOJ_1476 {
    fun solve() {
        val (E, S, M) = readln().split(" ").map { it.toInt() }
        var year = 0

        while (true) {
            val e = year % 15 + 1
            val s = year % 28 + 1
            val m = year % 19 + 1

            if (e == E && s == S && m == M) {
                println(year + 1) // 문제 기준은 1,1,1  실제 연도는 + 1
                break
            }
            year++
        }
    }
}

fun main() {
    BOJ_1476().solve()
}