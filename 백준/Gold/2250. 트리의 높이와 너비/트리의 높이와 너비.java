import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] minArr, maxArr;
    static int treeLevel = 0;
    static int idx = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inCount = new int[N + 1];
        Node[] list = new Node[N + 1];
        minArr = new int[N + 1];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        maxArr = new int[N + 1];
        // 순서대로 안들어올수도 있다.
        for (int i = 1; i <= N; i++) {
            int pNode = sc.nextInt();
            int leftNode = sc.nextInt();
            int rightNode = sc.nextInt();
            if (list[pNode] == null) list[pNode] = new Node(pNode);
            if (leftNode != -1) {
                if (list[leftNode] == null) list[leftNode] = new Node(leftNode);
                list[pNode].setLeft(list[leftNode]);
                inCount[leftNode]++;
            }
            if (rightNode != -1) {
                if (list[rightNode] == null) list[rightNode] = new Node(rightNode);
                list[pNode].setRight(list[rightNode]);
                inCount[rightNode]++;
            }

        }
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (inCount[i] == 0) {
                root = i;
                break;
            }
        }
        preOrder(list[root], 1);
        int level = 0;
        int maxWidth = 0;
        for (int i = 1; i <= treeLevel; i++) {
            if (maxWidth < maxArr[i] - minArr[i] + 1) {
                maxWidth = maxArr[i] - minArr[i] + 1;
                level = i;
            }
        }
        System.out.println(level + " " + maxWidth);
    }

    public static void preOrder(Node node, int level) {
        if (node != null) {
            treeLevel = Math.max(level, treeLevel);
            preOrder(node.getLeft(), level + 1);
            minArr[level] = minArr[level] > idx ? idx : minArr[level];
            maxArr[level] = maxArr[level] < idx ? idx : maxArr[level];
            idx++;
            preOrder(node.getRight(), level + 1);
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }
}