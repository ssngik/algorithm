package inflearn.hashMapTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class section4_unit3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 매출액 개수
        int k = Integer.parseInt(input[1]); // k 구간 매출액 종류
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = arr[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> answer = new ArrayList<>(); // 정답
        HashMap<Integer, Integer> HM = new HashMap<>(); // 매출액 리스트 해시맵

        for(int i=0; i<k-1; i++){ // setting value
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }
        //sliding window
        int lt = 0;
        for(int rt=k-1; rt<n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size()); // key 의 종류를 answer 에 add
            HM.put(arr[lt], HM.get(arr[lt])-1); // lt 값 하나 감소
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]); // lt의 값이 0 이 되어도 window 상 남아 있기 때문에
            lt++;
        }

        for(int x : answer) System.out.print(x + " ");

    }
}
