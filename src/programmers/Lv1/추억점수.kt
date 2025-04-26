package programmers.Lv1

class 추억점수 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val scoreMap = name.zip(yearning.toList()).toMap()

        val answer = photo.map { inPhoto ->
            inPhoto.sumOf { person ->
                scoreMap[person] ?: 0
            }
        }

        return answer.toIntArray()
    }
}