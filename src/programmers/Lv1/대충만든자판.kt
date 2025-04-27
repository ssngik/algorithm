package programmers.Lv1

class 대충만든자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val minTouch = mutableMapOf<Char, Int>()

        for (key in keymap) {
            for (i in key.indices) {
                val keyCap = key[i]

                minTouch[keyCap] = minOf(minTouch.getOrDefault(keyCap, Int.MAX_VALUE), i + 1)
            }
        }


        // 키보드 누름 계산
        for (target in targets) {
            var cnt = 0
            for (c in target) {
                val touch = minTouch[c]

                if (touch == null) {
                    cnt = -1
                    break
                }
                cnt += touch
            }
            answer.add(cnt)
        }
        return answer.toIntArray()
    }
}