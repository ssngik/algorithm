package baekjoon.twoPointer

import java.io.*

class BOJ_22922 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, K) = br.readLine().split(" ").map { it.toInt() } // K : 같은 숫자 최대 몇 번까지 가능한지 /
        val arr = br.readLine().split(" ").map { it.toInt() }

        val count = mutableMapOf<Int, Int>()
        var maxLength = 0 // 최장 연속 부분 수열 길이
        var left = 0

        for (right in arr.indices) {
            count[arr[right]] = count.getOrDefault(arr[right], 0) + 1

            // k보다 많이 등장한 숫자가 있는 경우
            while (count[arr[right]]!! > K) {
                count[arr[left]] = count[arr[left]]!! - 1

                if (count[arr[left]] == 0) { count.remove(arr[left]) } // 등장 횟수 0
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        println(maxLength)
    }
}

fun main() { BOJ_22922().solve() }