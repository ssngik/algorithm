package programmers.Lv2

import kotlin.math.sqrt

fun solution(numbers: String): Int {
    val numberSet = mutableSetOf<Int>()

    fun generateNumber(current: String, remaining: String) {
        if (current.isNotEmpty()) {
            numberSet.add(current.toInt())
        }

        for (i in remaining.indices) {
            generateNumber(current+remaining[i], remaining.removeRange(i, i+1))
        }
    }

    generateNumber("", numbers) // 순열 생성 시작

    return numberSet.count { isPrime(it) }
}

fun isPrime(num: Int) : Boolean {
    if (num < 2) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % 2 == 0) return false
    }
    return true
}
