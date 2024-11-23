import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb;
    static class Node {
        String node;
        Node left;
        Node right;

        Node(String node) {
            this.node = node;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        Map<String,Node> nodeMap = new HashMap<>();

        void add(String parent, String left, String right) {
            Node parentNode = nodeMap.computeIfAbsent(parent, Node::new);
            if(left != null) {
                parentNode.left = nodeMap.computeIfAbsent(left, Node::new);
            }
            if(right != null) {
                parentNode.right = nodeMap.computeIfAbsent(right, Node::new);
            }
        }

        void reOrder(Node node) { // 전위 루트 → 왼쪽 → 오른쪽
            sb.append(node.node);
            if(node.left != null) {
                reOrder(node.left);
            }
            if(node.right != null) {
                reOrder(node.right);
            }
        }

        void inOrder(Node node) { // 중위 왼쪽 → 루트 → 오른쪽
            if(node.left != null) {
                inOrder(node.left);
            }
            sb.append(node.node);
            if(node.right != null) {
                inOrder(node.right);
            }
        }

        void postOrder(Node node) { // 후위 왼쪽 → 오른쪽 → 루트
            if(node.left != null) {
                postOrder(node.left);
            }
            if(node.right != null) {
                postOrder(node.right);
            }
            sb.append(node.node);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        BinaryTree tree = new BinaryTree();
        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.add(parent, left.equals(".") ? null : left, right.equals(".") ? null : right);
        }

        Node root = tree.nodeMap.get("A");
        tree.reOrder(root);
        sb.append("\n");
        tree.inOrder(root);
        sb.append("\n");
        tree.postOrder(root);
        System.out.println(sb.toString());

    }



}

