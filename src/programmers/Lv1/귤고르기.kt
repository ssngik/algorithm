package programmers.Lv1

class 귤고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {
        val typeMap = mutableMapOf<Int,Int>()

        for (t in tangerine) {
            typeMap[t] = typeMap.getOrDefault(t, 0) + 1
        }

        val count = typeMap.values.sortedDescending()

        var sum = 0
        var kind = 0
        for (cnt in count) {
            sum += cnt
            kind++
            if (sum >= k) break
        }

        return kind
    }
}