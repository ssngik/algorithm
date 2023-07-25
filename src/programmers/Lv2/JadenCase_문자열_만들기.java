package programmers.Lv2;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {

        StringBuilder answer = new StringBuilder();

        boolean newWord = true; // 새 단어 여부 체크

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) { // 숫자 또는 공백이 아닌 경우
                if (newWord) {
                    answer.append(Character.toUpperCase(c));
                    newWord = false;
                } else {
                    answer.append(Character.toLowerCase(c));
                }
            } else { // 숫자 또는 공백인 경우
                answer.append(c);
                newWord = c == ' '; // 공백인 경우에만 새로운 단어
            }
        }

        return answer.toString();
    }

}
