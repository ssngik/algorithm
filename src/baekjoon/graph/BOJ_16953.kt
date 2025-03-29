package baekjoon.graph

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_16953 {

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var (A, B) = br.readLine().split(" ").map { it.toInt() }

        var cnt = 1

        while (B > A) {
            if (B % 2 == 0) {  // B가 짝수인 경우
                B /= 2
            } else if (B % 10 == 1) {  // B가 홀수, 끝자리가 1이면 1 제거
                B /= 10
            } else {  // 위 두 조건이 아닌경우
                println(-1)
                return
            }
            cnt++
        }

        if (B == A) println(cnt)
        else println(-1)  // 변환 불가
    }
}

fun main() {
    BOJ_16953().solve()
}