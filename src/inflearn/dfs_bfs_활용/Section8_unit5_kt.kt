package inflearn.dfs_bfs_활용

import java.io.*

class Section8_unit5_kt {
    var minCoins = Int.MAX_VALUE  // 최소 동전 개수

    fun dfs(depth: Int, sum: Int, coins: List<Int>, target: Int) {

        if (sum > target) return // 거슬러줄 금액을 넘어간 경우
        if (depth >= minCoins) return  // 최소 동전 개수를 넘은 경우
        if (sum == target) { // // 거슬러줄 금액이 됐을 때
            minCoins = minOf(minCoins, depth)  // 최솟값 업데이트
            return
        }

        for (coin in coins) {
            dfs(depth + 1, sum + coin, coins, target)
        }
    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()
        val coins = br.readLine().split(" ").map { it.toInt() }.sortedDescending() // 큰 값부터 정렬
        val M = br.readLine().toInt()

        dfs(0, 0, coins, M)

        println(minCoins)
    }
}

fun main() {
    Section8_unit5_kt().solve()
}
