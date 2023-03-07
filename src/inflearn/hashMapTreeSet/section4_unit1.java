package inflearn.hashMapTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class section4_unit1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        // getOrDefault(x, 0) -> x 의 key 값을 가져오고, 없다면 0을 return
        for(char x : input.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                answer=key;
            }
        }
        System.out.print(answer);


    }
}
