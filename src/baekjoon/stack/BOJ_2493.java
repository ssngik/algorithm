package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {

        // 5
        // 6 9 5 7 4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 탑의 수
        int n = Integer.parseInt(br.readLine());

        // 공백 구분으로 주어지는 탑
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑을 저장할 stack
        Stack<int[]> tower = new Stack<>();

        // 6
        // [2 9]
        // 9 5

        for(int i=1; i<=n; i++){
            int input = Integer.parseInt(st.nextToken()); // input
            while(!tower.isEmpty()){
                if(tower.peek()[1] > input) { // 서로 다른 높이라 >= 가 아닌 >. |||| 바로 오른쪽보다 크면 수신 가능
                    System.out.print(tower.peek()[0] + " ");
                    break;
                }else{
                    tower.pop(); // 더 이상 필요 없음.
                }

            }
            if(tower.isEmpty()) System.out.print("0 ");

            tower.push(new int[] {i, input});
        }
    }
}
