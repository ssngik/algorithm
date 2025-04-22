package programmers.Lv2

class `H-Index` {
    fun solution(citations: IntArray): Int {
        val sorted = citations.sortedDescending()  // 내림차순 /
        for (i in sorted.indices) {
            val h = i + 1  // 현재 인덱스까지 총 h편
            if (sorted[i] < h) {
                return i  // 처음 조건 깨는 순간 이전
            }
        }
        return citations.size  // 모두 만족하는 경우
    }
}