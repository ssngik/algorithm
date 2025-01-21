package programmers.Lv2

class TargetNumberSolution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {


        dfs (0, 0, numbers, target)

        return answer
    }

    fun dfs(depth: Int, sum: Int, numbers :IntArray, target: Int ) {
        if (depth == numbers.size) {
            if (sum == target) answer++
        }else {

            dfs(depth + 1, sum + numbers[depth], numbers, target)
            dfs(depth + 1, sum - numbers[depth], numbers, target)
        }

    }
}