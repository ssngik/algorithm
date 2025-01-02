package programmers.Lv3

class Solution {
    fun solution(N: Int, number: Int): Int {
        if (N == number) return 1
        val dp = Array(9) { mutableSetOf<Int>() }

        // 붙은 숫자. 5, 55, 555 ..
        for (i in 1..8) {
            dp[i].add(N.toString().repeat(i).toInt())
        }

        for (k in 2..8) { //  N을 k번 사용
            for (i in 1 until k) { // dp[i], dp[k-i] 조합
                for (a in dp[i]) {
                    for (b in dp[k-i]) {
                        dp[k].add(a + b)
                        dp[k].add(a - b)
                        dp[k].add(a * b)
                        if (b != 0) dp[k].add(a / b)
                    }
                }
            }

            // 찾으면 종료
            if (number in dp[k]) return k
        }

        // N은 최대 8번까지 사용 가능
        return -1
    }
}