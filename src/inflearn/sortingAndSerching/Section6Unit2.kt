package inflearn.sortingAndSerching

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
6
13 5 11 7 23 15
*/


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = IntArray(n)

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    // 버블 정렬 구현
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // swap
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }

    println(arr.joinToString(" "))
}