package programmers.Lv2;


// 연속된 부분수열의 합
class 연속된_부분수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int leftAns = 0;
        int rightAns = sequence.length - 1;
        int lt=0, sum=0;

        for (int rt=0; rt<sequence.length; rt++){
            sum += sequence[rt];

            while (sum > k){
                sum -= sequence[lt++];
            }

            // 부분 수열의 합이 같아진 경우
            if (sum == k){

                // 더 짧은 길이
                if ( rt - lt < rightAns - leftAns ){
                    rightAns = rt;
                    leftAns = lt;
                }
                // 길이가 짧은 수열이 여러 개인 경우 앞쪽에 나오는 수열
                if ( rt - lt == rightAns - leftAns && lt < leftAns){
                    rightAns = rt;
                    leftAns = lt;
                }
            }
            answer[0] = leftAns;
            answer[1] = rightAns;

        }

        return answer;
    }
}
