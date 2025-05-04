package programmers.Lv2

class 공원산책 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        //var answer: IntArray = intArrayOf()

        val height = park.size
        val width = park[0].length

        val dirOption = mapOf(
            "N" to Pair(-1, 0),
            "S" to Pair(1, 0),
            "W" to Pair(0, -1),
            "E" to Pair(0, 1)
        )

        var startX = 0
        var startY = 0

        // 시작 지점
        for (i in park.indices) {
            val index = park[i].indexOf('S')

            if (index != -1) {
                startX = index
                startY = i
                break
            }
        }

        var curX = startX
        var curY = startY

        for (route in routes) {
            val (dir, distChar) = route.split(" ") // op, n
            val dist = distChar.toInt() // 이동할 칸의 수
            val (dy, dx) = dirOption.getValue(dir)

            var nx = curX
            var ny = curY

            var moveable = true

            for (i in 1..dist) {
                nx += dx
                ny += dy

                // 벗어나는 경우
                if (nx !in 0 until width || ny !in 0 until height) {
                    moveable = false
                    break
                }

                // 갈 수 없는 곳
                if (park[ny][nx] == 'X') {
                    moveable = false
                    break
                }
            } // f


            if (moveable) {
                curX = nx
                curY = ny
            }

        }

        return intArrayOf(curY, curX)
    }
}