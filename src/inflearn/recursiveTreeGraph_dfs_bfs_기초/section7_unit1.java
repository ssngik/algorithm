package inflearn.recursiveTreeGraph_dfs_bfs_기초;

//DFS(3)을 만나게 되면 스택 프레임에 호출된 함수의 정보가 들어가게 된다. 그 정보는 대략 세 가지이다.
//매개 변수 정보
//지역 변수 정보
//복귀 주소



public class section7_unit1 {
    public void DFS(int n){
        if(n==0) return;
        else{
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args){
        section7_unit1 T = new section7_unit1();
        T.DFS(3);

    }
}
