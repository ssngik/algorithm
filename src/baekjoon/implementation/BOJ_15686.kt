package baekjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min


data class Point(val x : Int, val y : Int)

class BOJ_15686 {
    private val house = mutableListOf<Point>()
    private val chicken = mutableListOf<Point>()
    private lateinit var selected: BooleanArray
    private var M = 0
    private var minDis = Int.MAX_VALUE

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, m) = br.readLine().split(" ").map { it.toInt() }
        M = m

        // 집, 치킨집 좌표 저장
        repeat(N) { i ->
            br.readLine().split(" ").mapIndexed { j, value ->
                when (value.toInt()) {
                    1 -> house.add(Point(i, j))   // 집 좌표 추가
                    2 -> chicken.add(Point(i, j)) // 치킨집 좌표 추가
                    else -> {}
                }
            }
        }

        selected = BooleanArray(chicken.size)
        selectChicken(0, 0)

        println(minDis)
    }

    // 도시 치킨 거리 계산
    private fun getChickenDistance(): Int {
        var sum = 0
        for (h in house) {
            var dist = Int.MAX_VALUE
            for (idx in chicken.indices) {
                if (selected[idx]) {
                    val c = chicken[idx]
                    dist = min(dist, abs(h.x - c.x) + abs(h.y - c.y)) // 최소 거리 갱신
                }
            }
            sum += dist // // 집마다 최소 치킨 거리 더함
        }
        return sum
    }

    // 백트래킹으로 M개의 치킨집을 선택
    private fun selectChicken(index: Int, count: Int) {
        // 선택한 치킨집이 M개가 되면 치킨 거리 계산
        if (count == M) {
            minDis = min(minDis, getChickenDistance())
            return
        }

        // index부터 치킨집 리스트 끝까지 반복
        for (i in index until chicken.size) {
            if (!selected[i]) {
                selected[i] = true
                selectChicken(i + 1, count + 1)
                selected[i] = false
            }
        }
    }

}

fun main() {
    BOJ_15686().solve()
}