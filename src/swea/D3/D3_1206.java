package swea.D3;
import java.util.*;
import java.io.*;

public class D3_1206 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1; i<=10; i++){ // 10 개의 testCase
            int n = Integer.parseInt(br.readLine()); // 빌딩의 수
            st = new StringTokenizer(br.readLine()); // input

            int count=0; // 조망권이 확보된 세대 수
            int[] buildings = new int[n];

            for(int j=0; j<n; j++) buildings[j] = Integer.parseInt(st.nextToken());

            for(int k=2; k<n-2; k++){
                int target = buildings[k]; // 조망권을 검사할 건물

                // 주변 두 개의 건물보다 높은 경우
                if(target>buildings[k-1] && target > buildings[k-2] && target > buildings[k+1] && target > buildings[k+2]){
                    int leftHighest = Math.max(buildings[k-1], buildings[k-2]); // 2칸 내 왼편에서 가장 높은 건물
                    int rightHighest = Math.max(buildings[k+1],buildings[k+2]); // 2칸 내 오른편에서 가장 높은 건물
                    int mostHighest = Math.max(leftHighest, rightHighest); // 2 칸 내 가장 높은 건물

                    // 조망권 확보 세대 수
                    count += target - mostHighest;

                }
            }
            System.out.println("#"+i + " " + count);

        }// tc

    }
}
