package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit6_kt {
    lateinit var pm: IntArray  /// 선택된 숫자
    lateinit var ch: BooleanArray
    var N = 0
    var M = 0
    lateinit var number: List<Int>

    fun dfs(depth: Int) {
        if (depth == M) {  // M개 선택시 출력
            println(pm.joinToString(" "))
            return
        }

        for (i in 0 until N) {
            if (!ch[i]) {  // 사용되지 않은 숫자
                pm[depth] = number[i]  // 선택한 숫자
                ch[i] = true  // 사용 처리
                dfs(depth + 1)  //  다음 숫자 선택
                ch[i] = false  // 백트래킹
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        number = br.readLine().split(" ").map { it.toInt() }

        N = n
        M = m
        pm = IntArray(M)  // 선택된 숫자
        ch = BooleanArray(N)  // 사용 여부

        dfs(0)
    }
}

fun main() {
    Section8_unit6_kt().solve()
}