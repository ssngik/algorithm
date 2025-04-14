package inflearn.greedy
import java.io.*


data class Player(val height: Int, val weight: Int) : Comparable<Player> {
    override fun compareTo(other: Player): Int {
        return other.height - this.height // 키 기준 내림차순
    }
}

class Section9_unit1_kt {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val arr = mutableListOf<Player>()

        repeat(n) {
            val (h, w) = br.readLine().split(" ").map { it.toInt() }
            arr.add(Player(h, w))
        }

        arr.sort() // 키 기준 내림차순

        var count = 0
        var maxWeight = Int.MIN_VALUE

        for (p in arr) {
            if (p.weight > maxWeight) {
                maxWeight = p.weight
                count++
            }
        }

        println(count)
    }
}

fun main() {
    Section9_unit1_kt().solve()
}