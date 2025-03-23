package inflearn.dfs_bfs_활용

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Tomato(val x: Int, val y: Int)

class Section8_unit12_kt {
    private val dx = intArrayOf(-1, 0, 1, 0) // 상 우 하 좌
    private val dy = intArrayOf(0, 1, 0, -1)

    private lateinit var board: Array<IntArray> // 토마토 상태 1: 익음, 0: 안 익음, -1: 없음
    private lateinit var dis: Array<IntArray>   // 익은 날짜
    private lateinit var q: Queue<Tomato>
    private var n = 0 // 행
    private var m = 0 // 열

    fun bfs() {
        while (q.isNotEmpty()) {
            val tmp = q.poll()
            for (i in 0 until 4) {
                val nx = tmp.x + dx[i]
                val ny = tmp.y + dy[i]

                // 안 익은 토마토인 경우 0
                if (nx in 0 until n && ny in 0 until m && board[nx][ny] == 0) {
                    board[nx][ny] = 1
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1
                    q.offer(Tomato(nx, ny)) // 새로 익은 위치
                }
            }
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (mInput, nInput) = br.readLine().split(" ").map { it.toInt() }
        m = mInput
        n = nInput

        board = Array(n) { IntArray(m) }
        dis = Array(n) { IntArray(m) }
        q = LinkedList()

        for (i in 0 until n) {
            val row = br.readLine().split(" ").map { it.toInt() }
            for (j in 0 until m) {
                board[i][j] = row[j]
                if (board[i][j] == 1) {
                    q.offer(Tomato(i, j))
                }
            }
        }

        bfs()

        var ripe = true // 전부 익었는지
        var answer = Int.MIN_VALUE

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 0) ripe = false // 아직 안 익은 게 있으면 false
            }
        }

        // 전부 익은경ㅇ우
        if (ripe) {
            for (i in 0 until n) {
                for (j in 0 until m) {
                    answer = maxOf(answer, dis[i][j])
                }
            }
            println(answer)
        } else {
            println(-1)
        }
    }
}

fun main() {
    Section8_unit12_kt().solve()
}