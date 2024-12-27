package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

// 방향 벡터
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

var N = 0 // 행,
var M = 0 // 열

lateinit var map: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt() // test case

    repeat(t) {
        val (m, n, K) = br.readLine().split(" ").map { it.toInt() } // 가로, 세로, 배추 위치 개수
        M = m
        N = n

        map = Array(N) { Array(M) { 0 } } // 2차원 배열
        var cnt = 0

        // 배추 심기
        repeat(K) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            map[y][x] = 1
        }

        // 탐색
        repeat(N) { x ->
            repeat(M) { y ->
                if (dfs(x, y)) cnt++
            }
        }

        println(cnt)
    }
}

fun dfs(x: Int, y: Int): Boolean {
    if (map[x][y] == 0) return false

    map[x][y] = 0 // 방문 체크

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until N || ny !in 0 until M || map[nx][ny] == 0) continue

        dfs(nx, ny)
    }
    return true
}