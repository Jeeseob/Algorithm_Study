package gold.problem5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        String tempData;

        BinarySearchTree root = new BinarySearchTree(Integer.parseInt(br.readLine()));

        // 입력 갯수가 정해지지 않았을 때, 입력방법.
        while(true) {
            tempData = br.readLine();
            if (tempData == null || tempData.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(tempData));
        }

        searchTree(root);

    }

    // DFS로 탐색하면서, 마지막에 출력하면 Post Order
    private static void searchTree(BinarySearchTree tempNode) {
        if(tempNode.getLeft() != null) {
            searchTree(tempNode.getLeft());
        }

        if (tempNode.getRight() != null) {
            searchTree(tempNode.getRight());
        }

        System.out.println(tempNode.getTemp());
    }
}

class BinarySearchTree {
    private BinarySearchTree left;
    private BinarySearchTree right;
    private int temp;

    public BinarySearchTree(int temp) {
        this.temp = temp;
        this.left = null;
        this.right = null;
    }

    public void insert(int nextNode) {
        if(nextNode > temp) {
            if(right == null) {
                right = new BinarySearchTree(nextNode);
            } else {
                right.insert(nextNode);
            }
        }
        else {
            if(left == null) {
                left = new BinarySearchTree(nextNode);
            } else {
                left.insert(nextNode);
            }
        }
    }

    public int getTemp() {
        return temp;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public BinarySearchTree getRight() {
        return right;
    }
}