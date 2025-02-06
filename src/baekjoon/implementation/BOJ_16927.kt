package baekjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader


// BOJ_16927
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, R) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    rotate(map, N, M, R)
    map.forEach { println(it.joinToString(" ")) }
}

private fun rotate(map: Array<IntArray>, n: Int, m: Int, r: Int) {
    val layer = minOf(n, m) / 2  // 돌릴 레이어 개수

    val dx = arrayOf(1, 0, -1, 0) // 하 좌 상
    val dy = arrayOf(0, 1, 0, -1)

    for (i in 0 until layer) {
        val width = m - 2 * i
        val height = n - 2 * i
        val cycle = 2 * (width + height - 2)  // 한 바퀴 도는 개수
        val rotation = r % cycle  // 실제로 몇 번 수행될지

        repeat(rotation) {
            var x = i
            var y = i
            var dir = 0
            var prevValue = map[x][y]  // 이전값

            while (dir < 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]

                if (nx !in i until n - i || ny !in i until m - i) {
                    dir++ // 방향 변경
                    continue
                }

                val temp = map[nx][ny]
                map[nx][ny] = prevValue
                prevValue = temp

                x = nx
                y = ny
            }
        }
    }
}
