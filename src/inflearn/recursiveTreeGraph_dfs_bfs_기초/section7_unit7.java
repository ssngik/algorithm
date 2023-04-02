package inflearn.recursiveTreeGraph_dfs_bfs_기초;

import java.util.*;
class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}

public class section7_unit7{
    Node root;
    public void BFS(Node root){
        Queue<Node> Q=new LinkedList<>(); // Node 객체를 저장하는 Queue

        Q.add(root);
        int L=0; // root Node 0

        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print("Level " + L+" : ");

            for(int i=0; i<len; i++){ // 원소 개수만큼
                // -> 꺼내고 출력
                Node cur = Q.poll(); // 현재 노드
                System.out.print(cur.data + " ");
                // <-

                if(cur.lt!=null) Q.add(cur.lt);
                if(cur.rt!=null) Q.add(cur.rt);
            }
            L++;
            System.out.println();
        }

    }

    public static void main(String args[]) {

        section7_unit7 tree=new section7_unit7();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root); // tree.root -> root Node 의 주소
    }
}
