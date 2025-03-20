package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit8_kt {
    private lateinit var b: IntArray // combination 배열
    private lateinit var p: IntArray // 순열
    private lateinit var ch: IntArray
    private var n = 0 // 가장 윗줄의 숫자 개수
    private var f = 0 // 가장 밑에 있는 숫자
    private var flag = false
    private val dy = Array(35) { IntArray(35) } // 조합 값

    fun combi(n: Int, r: Int): Int {
        if (dy[n][r] > 0) return dy[n][r]
        if (n == r || r == 0) return 1
        dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r)
        return dy[n][r]
    }

    fun dfs(L: Int, sum: Int) {
        if (flag) return
        if (L == n) { // 순열 완성
            if (sum == f) {
                println(p.joinToString(" "))
                flag = true
            }
        } else {
            for (i in 1..n) { // i 자체가 순열의 수
                if (ch[i] == 0) {
                    ch[i] = 1
                    p[L] = i // 순열 생성
                    dfs(L + 1, sum + (p[L] * b[L]))
                    ch[i] = 0
                }
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (nInput, fInput) = br.readLine().split(" ").map { it.toInt() }
        n = nInput
        f = fInput

        b = IntArray(n) // combination 값
        p = IntArray(n) // 순열
        ch = IntArray(n + 1) // 체크 배열

        for (i in 0 until n) {
            b[i] = combi(n - 1, i)
        }

        dfs(0, 0)
    }
}

fun main() {
    Section8_unit8_kt().solve()
}