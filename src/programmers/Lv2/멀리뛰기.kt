package programmers.Lv2

class 멀리뛰기 {
    fun solution(n: Int): Long {
        var a = 1L  // dp 0
        var b = 1L  // dp 1

        for (i in 2..n) {
            val temp = (a + b) % 1234567
            a = b
            b = temp
        }

        return b
    }
}