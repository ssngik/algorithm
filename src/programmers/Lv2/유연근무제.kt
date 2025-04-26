package programmers.Lv2

class 유연근무제 {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer = 0
        for (i in schedules.indices) {
            var success = true

            // 희망 시각 + 10분
            var hopeTime = schedules[i]
            var hour = hopeTime / 100
            var minute = hopeTime % 100

            minute += 10

            if (minute >= 60) {
                hour += 1
                minute -= 60
            }
            val limitTime = hour * 100 + minute

            for (j in 0 until 7) {
                val day = (startday + j) % 7

                // 평일만 확인
                if (day in 1..5) {
                    if (timelogs[i][j] > limitTime) {

                        success = false
                        break
                    }
                }
            }

            if (success) { answer++ }
        }

        return answer
    }
}