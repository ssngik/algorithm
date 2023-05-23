package inflearn.dfs_bfs_활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// N의 수가 작아서 DFS 가능
// N 제한 커지면 Dynamic 으로
public class Section8_unit5 {
    static int N, M, answer=Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr){

        // 거슬러줄 금액을 넘어간 경우
        if(sum > M) return;

        // 더 깊은 경우 볼 필요가 없음
        if(L >= answer) return;

        // 거슬러줄 금액이 됐을 때
        if(sum == M){
            answer=Math.min(answer, L);
        }
        else{ // DFS
            for(int i=0; i<N; i++){
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 동전의 개수
        N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        // N 개의 동전의 종류
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i]= Integer.parseInt(st.nextToken());

        // 시간 복잡도 고려
        Arrays.sort(arr, Collections.reverseOrder());

        // 거슬러줄 금액
        M = Integer.parseInt(br.readLine());

        Section8_unit5 T = new Section8_unit5();
        T.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
