package programmers.Lv2

class 괄호회전하기 {
    fun solution(s: String): Int {
        var answer = 0

        for (i in s.indices) {
            val rotated = s.rotateLeft(i)

            if (isValid(rotated)) answer++

        }

        return answer
    }



    private fun isValid(s: String) : Boolean {
        val stack = ArrayDeque<Char>()

        for (ch in s) {
            when (ch) {
                '(' , '[', '{' -> stack.addLast(ch)

                ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
                ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
                '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
            }
        }
        return stack.isEmpty()
    }

    private fun String.rotateLeft(x: Int): String {
        return this.substring(x) + this.substring(0, x)
    }
}