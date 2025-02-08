package softeer.Lv2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val S = br.readLine()

    val started = BooleanArray(S.length + 1) { false } // 1이나 + 추가 여부
    val sb = StringBuilder()
    var depth = 0

    for (c in S) {
        if (c == '(') {
            // 이미 1이 추가된적 있는 경우
            if (started[depth]) {
                sb.append('+')
            }
            // 여는 괄호
            sb.append('(')
            depth++
            started[depth] = false
        } else { // c == ')'
            // 아직 아무것도 안 쓴 경우 (빈 괄호)
            if (!started[depth]) {
                sb.append('1')
            }
            sb.append(')')
            depth--
            started[depth] = true
        }
    }

    println(sb.toString())
}