package inflearn.sortingAndSerching

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Section6Unit1 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        // N개의 숫자
        val n = br.readLine().toInt()
        val arr = IntArray(n)

        // target 숫자
        val st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            arr[i] = st.nextToken().toInt()
        }

        // 선택 정렬 구현
        for (i in 0 until n - 1) {
            var minIdx = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j
                }
            }
            // Swap
            val temp = arr[i]
            arr[i] = arr[minIdx]
            arr[minIdx] = temp
        }

        println(arr.joinToString(" "))
    }
}

fun main() {
    Section6Unit1().solve()
}