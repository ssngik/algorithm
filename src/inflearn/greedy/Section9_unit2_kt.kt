package inflearn.greedy

import java.io.*

data class Meeting(val start: Int, val end: Int) : Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int { // 끝나는 시간 오름차순, 같으면 시작 시간 오름차순
        return if (this.end == other.end) this.start - other.start
        else this.end - other.end
    }
}

class Section9_unit2_kt {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val list = mutableListOf<Meeting>()

        repeat(n) {
            val (s, e) = br.readLine().split(" ").map { it.toInt() }
            list.add(Meeting(s, e))
        }

        list.sort()

        var cnt = 0
        var endTime = 0

        for (m in list) { // 겹치지 않으면 선택
            if (m.start >= endTime) {
                cnt++
                endTime = m.end
            }
        }

        println(cnt) // 최대 회의 개수
    }
}

fun main() {
    Section9_unit2_kt().solve()
}