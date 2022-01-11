import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1991_트리순회 {
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++){
            char[] input = br.readLine().replaceAll(" ", "").toCharArray();
            //System.out.println(Arrays.toString(input));
            createTree(input[0], input[1], input[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void createTree(char Data, char leftData, char rightData) {
        if(root == null){
            root = new Node(Data);
            if(leftData != '.') root.left = new Node(leftData);
            if(rightData != '.') root.right = new Node(rightData);
        } else {
            searchNode(root, Data, leftData, rightData);
        }
    }

    private static void searchNode(Node root, char data, char leftData, char rightData) {
        if(root == null) return;
        else if(root.data == data){
            if(leftData != '.') root.left = new Node(leftData);
            if(rightData != '.') root.right = new Node(rightData);
        } else {
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    private static void preOrder(Node node){
        System.out.print(node.data);
        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    }

    private static void inOrder(Node node){

        if(node.left != null) inOrder(node.left);
        System.out.print(node.data);
        if(node.right != null) inOrder(node.right);
    }

    private static void postOrder(Node node){

        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.print(node.data);
    }
}
