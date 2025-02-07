package programmers.Lv1

class 최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int {
        val max = ArrayList<Int>()
        val min = ArrayList<Int>()

        for (i in sizes) {
            if (i[0] > i[1]) {
                max.add(i[0])
                min.add(i[1])
            } else {
                min.add(i[0])
                max.add(i[1])
            }
        }

        return max.maxOrNull()!! * min.maxOrNull()!!
    }
}