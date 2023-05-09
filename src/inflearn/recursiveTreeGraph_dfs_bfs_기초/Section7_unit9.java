package inflearn.recursiveTreeGraph_dfs_bfs_기초;


// DFS 는 자식이 하나만 있는게 아니라 있다면 둘 다 있어야 한다.
// 최단거리 문제는 BFS 가 정답임
// 배워보는 입장에서 DFS 를 해보는 것.


class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}
public class Section7_unit9 {
    Node root;
    public int DFS(int L, Node root){ // root 는 Node 를 가르키는 거지 고정된 100번지 값이 아님
        if(root.lt==null && root.rt==null) return L; // root 가 가르키는 노드의 레벨 ( 노드 까지의 거리 )
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));

    }
    public static void main(String[] args) {

        Section7_unit9 tree = new Section7_unit9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
