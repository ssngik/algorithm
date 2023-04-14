package inflearn.recursiveTreeGraph_dfs_bfs_기초;
import java.util.*;

class Node{
    int data;
    Node lt, rt; // 왼쪽과 오른쪽 자식 Node 주소 저장 변수
    public Node(int val){
        data=val;
        lt=rt=null;
        }
    }

public class section7_unit5{
    Node root;
    public void DFS(Node root){
        if(root==null) return; // 말단 노드
        else{ // print 위치에 따라 달라짐
            DFS(root.lt);
            System.out.print(root.data+" "); // 중위 순회
            DFS(root.rt);
        }
    }

    public static void main(String args[]) {
        section7_unit5 tree=new section7_unit5();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);
    }
}
