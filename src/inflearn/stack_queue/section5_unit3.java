package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class section5_unit3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int answer=0;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n]; // 격자판
        // 인형
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 크레인 작동 위치
        int m = Integer.parseInt(br.readLine()); // moves 배열의 길이
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) moves[i] = Integer.parseInt(st.nextToken());

        for(int x : moves){
            for(int i=0; i<n; i++){
                if(board[i][x-1]!=0){
                    int tmp = board[i][x-1];
                    board[i][x-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()){
                        stack.pop();
                        answer+=2;
                    }else stack.push(tmp);
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
