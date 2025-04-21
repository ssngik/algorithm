package programmers.Lv1

class K번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { (i, j, k) ->
            array.slice((i - 1)..(j - 1))
                .sorted()
                .get(k - 1)
        }.toIntArray()
    }
}
