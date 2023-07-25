package programmers.Lv2;

import java.util.*;

public class 최댓값과_최솟값 {public String solution(String s) {
    String[] input = s.split(" ");

    int[] arr = new int[input.length];

    for (int i=0; i<input.length; i++){
        arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    int min = arr[0];
    int max = arr[arr.length - 1];

    return min + " " + max;
}
}
