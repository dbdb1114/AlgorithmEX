import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public static char[] getCharArr() throws IOException {
        return bf.readLine().replaceAll(" ", "").toCharArray();
    }

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();
        int N = getInt();
        for (int i = 0; i < N; i++) {
            char[] ar = getCharArr();
            tree.add(ar[0],ar[1],ar[2]);
        }

        String forward = tree.forwardRecursive();
        String med = tree.medRecursive();
        String back = tree.backRecursive();
        System.out.println(forward);
        System.out.println(med);
        System.out.println(back);
    }
}
class Tree{
    Node topNode;
    Map<Character, Node> list = new HashMap<>();

    public Tree() {}

    public void add(char value, char left, char right){
        if(Objects.isNull(topNode)){
            topNode = new Node(value);
            topNode.setChild(left,right);

            list.put(value, topNode);

            if(left != '.'){
                list.put(left,topNode.left);
            }
            if(right != '.'){
                list.put(right,topNode.right);
            }
        } else {

            list.get(value).setChild(left, right);

            if(left != '.'){
                list.put(left,list.get(value).left);
            }

            if(right != '.'){
                list.put(right,list.get(value).right);
            }
        }
    }
    public String forwardRecursive(){
        StringBuilder sb = new StringBuilder();
        sb.append(topNode.value);
        forwardRecursive(topNode,sb);
        return sb.toString();
    }
    public void forwardRecursive(Node node, StringBuilder sb){
        if(!Objects.isNull(node.left)){
            sb.append(node.left.value);
            forwardRecursive(node.left,sb);
        }
        if(!Objects.isNull(node.right)){
            sb.append(node.right.value);
            forwardRecursive(node.right,sb);
        }
    }

    public String medRecursive(){
        StringBuilder sb = new StringBuilder();
        medRecursive(topNode,sb);
        return sb.toString();
    }

    public void medRecursive(Node node, StringBuilder sb){
        if(!Objects.isNull(node.left)){
            medRecursive(node.left,sb);
        }

        if (!Objects.isNull(node.right)) {
            sb.append(node.value);
            medRecursive(node.right,sb);
        } else {
            sb.append(node.value);
        }
    }

    public String  backRecursive(){
        StringBuilder sb = new StringBuilder();
        backRecursive(topNode, sb);
        return sb.toString();
    }
    public void backRecursive(Node node,StringBuilder sb){
        if(!Objects.isNull(node.left)){
            backRecursive(node.left,sb);
        }
        if(!Objects.isNull(node.right)){
            backRecursive(node.right,sb);
        }
        sb.append(node.value);
    }

    class Node {

        char value;

        Node left;
        Node right;
        Node parent;

        public Node(char value){
            this.value = value;
        }

        public void setChild(char left, char right){
            if(left != '.'){
                this.left = new Node(left);
                this.left.parent = this;
            }
            if(right != '.'){
                this.right = new Node(right);
                this.right.parent = this;
            }
        }
    }

}

