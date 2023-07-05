package inflearn.greedy;


import java.util.*;
class Body implements Comparable<Body>{
    public int h, w; // 키, 무게
    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o){
        return o.h - this.h;
    }
}

class Section9_unit1 {
    public int solution(ArrayList<Body> arr, int n){

        int cnt = 0;
        Collections.sort(arr); // 내림차순 정렬

        int max = Integer.MIN_VALUE;
        for(Body ob : arr){
            if(ob.w > max){ // 몸무게만 체크
                max = ob.w;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){

        Section9_unit1 T = new Section9_unit1();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(); // 지원자 수

        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h=kb.nextInt();
            int w=kb.nextInt();

            arr.add(new Body(h, w));
        }

        System.out.println(T.solution(arr, n));

    }
}
