package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class section1_unit9 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuilder answer= new StringBuilder();

        for(int i=0; i<input.length(); i++)
            if(!Character.isAlphabetic(input.charAt(i))) answer.append(input.charAt(i));


        System.out.println(Integer.parseInt(answer.toString()));

        // 자바 for loop String 관련 검색 공부하기
        // https://choichumji.tistory.com/135 -> 관련 링크
        // 해당 파일 commit

    }
}
