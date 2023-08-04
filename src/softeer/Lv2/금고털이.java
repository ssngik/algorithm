package softeer.Lv2;

import java.util.*;
import java.io.*;

public class 금고털이 {
    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()); // 배낭의 무게
        int N = Integer.parseInt(st.nextToken()); // 귀금속의 종류
        ArrayList<int[]> list = new ArrayList<>();

        // 금속의 무게, 무게당 가격
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]); // 귀금속

        int answer = 0, weight = 0;

        for (int[] x : list){
            // 가방 무게보다 작은
            if (weight + x[0] <= W){
                weight = weight + x[0];
                answer += x[0] * x[1];
            }else{
                answer += (W - weight) * x[1];
            }
        }
        System.out.println(answer);
    }
}


