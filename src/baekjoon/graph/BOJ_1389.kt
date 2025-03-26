package baekjoon.graph

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_1389 {
    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M) = br.readLine().split(" ").map { it.toInt() } // 유저의 수, 친구 관계의 수

        val graph = Array(N + 1) { IntArray(N + 1) { 1000000 } }

        // 자기 자신 경로 0
        for (i in 1..N) {
            graph[i][i] = 0
        }

        repeat(M) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a][b] = 1
            graph[b][a] = 1
        }

        // 모든 쌍 최단 거리
        for (k in 1..N) {
            for (i in 1..N) {
                for (j in 1..N) {
                    graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
                }
            }
        }

        // 각 사람 케빈 베이컨 수 계산
        var minBacon = Int.MAX_VALUE
        var answer = -1

        for (i in 1..N) {
            val BaconNum = graph[i].slice(1..N).sum()

            if (BaconNum < minBacon) {
                minBacon = BaconNum
                answer = i
            } else if (BaconNum == minBacon) {
                answer = minOf(answer, i) // 번호가 작은 사람 선택
            }
        }

        println(answer)
    }
}

fun main() {
    BOJ_1389().solve()
}