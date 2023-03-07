package inflearn.hashMapTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class section4_unit2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input1 = br.readLine();
//        String input2 = br.readLine();
//        String answer = "YES";
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for(char x : input1.toCharArray()) map.put(x, map.getOrDefault(x, 0)+1);
//        for(char x : input2.toCharArray()) map.put(x, map.getOrDefault(x, 0)+1);
//
//
//        for(char key : map.keySet()){
//            if(map.get(key)%2==1) {
//                answer = "NO";
//                break;
//            }
//            else answer="YES";
//        }
//        System.out.println(answer);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : input1.toCharArray()) map.put(x, map.getOrDefault(x, 0)+1);
        for(char key : input2.toCharArray()){
            if(!map.containsKey(key) || map.get(key)==0){
                answer="NO";
                break;
            }
            map.put(key, map.get(key)-1);
        }
        System.out.println(answer);
    }
}
