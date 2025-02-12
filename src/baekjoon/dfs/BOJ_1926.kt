package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader


val dxDirs = listOf(-1, 0, 1, 0)
val dyDirs = listOf(0, 1, 0, -1)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() } // 세로, 가로

    val map = Array(N) {
        br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    val visited = Array(N) { BooleanArray(M) }

    var count = 0 // 그림 개수
    var maxSize = 0 // 최대 그림 크기

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 1 && !visited[i][j]) {
                count++
                maxSize = maxOf(maxSize, dfs(i, j, N, M, map, visited))
            }
        }
    }

    println(count)
    println(maxSize)
}

fun dfs(x: Int, y: Int, N: Int, M: Int, map: Array<IntArray>, visited: Array<BooleanArray>): Int {
    visited[x][y] = true
    var size = 1 // 현재 크기부터

    for (i in 0 until 4) {
        val nx = x + dxDirs[i]
        val ny = y + dyDirs[i]

        if (nx in 0 until N && ny in 0 until M && !visited[nx][ny] && map[nx][ny] == 1) {
            size += dfs(nx, ny, N, M, map, visited)
        }
    }
    return size
}