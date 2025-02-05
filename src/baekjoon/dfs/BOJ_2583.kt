package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_2583 {
    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)

    private lateinit var map: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private var M = 0
    private var N = 0

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        M = m
        N = n
        map  = Array(M) { IntArray(N) { 0 } }
        visited = Array(M) { BooleanArray(N) { false } }

        repeat(k) {
            val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
            for (i in y1 until y2) { // y 방향
                for (j in x1 until x2) { // x 방향
                    map[i][j] = 1 // 직사각형 부분
                }
            }
        }

        val areas = mutableListOf<Int>() // 영역 크기
        var count = 0 // 영역 개수

        // DFS 탐색
        for (i in 0 until M) {
            for (j in 0 until N) {
                if (map[i][j] == 0 && !visited[i][j]) { // 탐색 가능한 부분
                    areas.add(dfs(i, j))
                    count++ // 영역 개수 추가
                }
            }
        }

        println(count)
        println(areas.sorted().joinToString(" "))
    }

    private fun dfs(x: Int, y: Int) : Int {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(Pair(x, y))
        visited[x][y] = true
        var area = 1

        while (stack.isNotEmpty()) {
            val (cx, cy) = stack.pop()
            for (i in 0 until 4) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0 until M && ny in 0 until N && !visited[nx][ny] && map[nx][ny] == 0) {
                    stack.push(Pair(nx, ny))
                    visited[nx][ny] = true
                    area++
                }
            }
        }
        return area
    }
}

fun main() {
    BOJ_2583().solve()
}
