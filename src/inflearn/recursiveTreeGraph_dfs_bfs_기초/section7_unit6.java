package inflearn.recursiveTreeGraph_dfs_bfs_기초;

// 자연수 N이 주어지면 1부터 N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램 ( 공집합 출력 x )

class section7_unit6 {
    static int n;
    static int[] ch; // 체크 배열
    public void DFS(int L){
        if(L==n+1){ // 부분집합의 경우가 하나 만들어짐
            String tmp=""; // 부분집합

            for(int i=1; i<=n; i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp); // 공집합이 아니라면 출력
        }
        else{
            ch[L]=1; // 사용함
            DFS(L+1); // 왼
            ch[L]=0; // 사용하지 않음
            DFS(L+1); // 오
        }
    }

    public static void main(String[] args){
        section7_unit6 T = new section7_unit6();

        n=3;
        ch=new int[n+1]; // 인덱스 번호

        T.DFS(1);
    }
}
