package sliver.problem1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

    private static HashMap<String, Node> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        graph = new HashMap<>();

        int numberOfNod = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numberOfNod; i++) {
            st = new StringTokenizer(br.readLine());
            String tempNode = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();
            graph.put(tempNode,new Node(tempNode, leftNode, rightNode));
        }

        order("A","pre");
        System.out.println();
        order("A", "in");
        System.out.println();
        order("A", "post");

    }

    // 규칙을 기반으로 한번에 구현(최적화)
    private static void order(String temp , String order) {
        if(order.equals("pre")) {
            System.out.print(temp);
        }

        Node tempNode = graph.get(temp);

        if (!tempNode.getLeftNode().equals(".")) {
            order(tempNode.getLeftNode(), order);
        }

        if (order.equals("in")) {
            System.out.print(temp);
        }

        if (!tempNode.getRightNode().equals(".")) {
            order(tempNode.getRightNode(), order);
        }

        if (order.equals("post")) {
            System.out.print(temp);
        }
    }



    // 각각 구현
    private static void preorder(String temp) {
        System.out.print(temp);
        Node tempNode = graph.get(temp);

        if (!tempNode.getLeftNode().equals(".")) {
            preorder(tempNode.getLeftNode());
        }
        if (!tempNode.getRightNode().equals(".")) {
            preorder(tempNode.getRightNode());
        }
    }

    private static void inorder(String temp) {
        Node tempNode = graph.get(temp);
        if (!tempNode.getLeftNode().equals(".")) {
            inorder(tempNode.getLeftNode());
        }
        System.out.print(temp);
        if (!tempNode.getRightNode().equals(".")) {
            inorder(tempNode.getRightNode());
        }
    }

    private static void postorder(String temp) {
        Node tempNode = graph.get(temp);
        if (!tempNode.getLeftNode().equals(".")) {
            postorder(tempNode.getLeftNode());
        }
        if (!tempNode.getRightNode().equals(".")) {
            postorder(tempNode.getRightNode());
        }
        System.out.print(temp);
    }
}

class Node {
    private String tempNode;
    private String leftNode;
    private String rightNode;

    public Node(String tempNode, String leftNode, String rightNode) {
        this.tempNode = tempNode;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public String getTempNode() {
        return tempNode;
    }

    public String getLeftNode() {
        return leftNode;
    }

    public String getRightNode() {
        return rightNode;
    }
}