package programmers.Lv2

class 가장큰수 {
    fun solution(numbers: IntArray): String {
        val result = numbers
            .map { it.toString() }
            .sortedWith { a, b -> (b + a).compareTo(a + b) }
            .joinToString("")

        return if (result.startsWith("0")) "0" else result
    }

}