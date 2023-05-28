package inflearn.dfs_bfs_활용;
import java.util.*;

class Section8_unit8{
    static int[] b, p, ch; // combination 값, 순열, 체크배열
    static int n, f;       // 가장 윗줄에 있는 숫자의 개수, 가장 밑에 줄에 있는 수
    boolean flag=false;
    int[][] dy=new int[35][35];
    public int combi(int n, int r){

        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L==n){ // 순열 완성
            if(sum==f){
                for(int x : p) System.out.print(x+" ");
                flag=true;
            }
        }
        else{
            for(int i=1; i<=n; i++){ // i 자체가 순열의 수
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i; // 순열 생성
                    DFS(L+1, sum+(p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        Section8_unit8 T = new Section8_unit8();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt(); // 가장 윗줄에 있는 숫자의 개수
        f=kb.nextInt(); // 가장 밑에 줄에 있는 수

        b=new int[n]; // combination 값
        p=new int[n]; // 순열
        ch=new int[n+1]; // 체크배열

        for(int i=0; i<n; i++){
            b[i]=T.combi(n-1, i);
        }

        T.DFS(0, 0);
    }
}