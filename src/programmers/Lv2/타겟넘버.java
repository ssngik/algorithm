package programmers.Lv2;

class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs (0, 0, numbers, target);

        return answer;
    }
    public void dfs(int depth, int sum, int[] numbers, int target){
        // 전체 숫자 탐색 완료 한 경우
        if (depth == numbers.length){
            // traget number와 같아진 경우
            if (target == sum) answer++;
        }else{
            // 다음 숫자 더하기
            dfs (depth + 1, sum + numbers[depth], numbers, target);
            // 다음 숫자 빼기
            dfs (depth + 1, sum - numbers[depth], numbers, target);
        }

    }
}