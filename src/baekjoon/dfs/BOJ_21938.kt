package baekjoon.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ_21938 {
    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, 1, 0, -1)

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val image = Array(n) { IntArray(m) }


        for (i in 0 until n) {
            val pixelLine = br.readLine().split(" ").map { it.toInt() }

            for (j in 0 until m) {
                val r = pixelLine[j * 3]
                val g = pixelLine[j * 3 + 1]
                val b = pixelLine[j * 3 + 2]
                val avg = (r + g + b) / 3
                image[i][j] = avg
            }
        }

        val T = br.readLine().toInt() // 경계값


        // T 기준 이진화
        val bin = Array(n) { i ->
            IntArray(m) {j ->
                if (image[i][j] >= T) 255 else 0
            }
        }

        var cnt = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (bin[i][j] == 255) {
                    dfs(i, j, bin, n, m)
                    cnt++
                }
            }
        }

        println(cnt)
    }

    private fun dfs(y: Int, x: Int, bin: Array<IntArray>, n: Int, m: Int) {
        bin[y][x] = 0

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            if (ny in 0 until n && nx in 0 until m && bin[ny][nx] == 255) {
                dfs(ny, nx, bin, n, m)
            }
        }
    }
}

fun main() {
    BOJ_21938().solve()
}