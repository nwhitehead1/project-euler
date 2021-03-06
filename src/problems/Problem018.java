package problems;

import lib.Library;
import lib.models.Node;
import runner.ProjectEulerCallable;

public class Problem018 implements ProjectEulerCallable {

    private static final String TREE = "75\r\n" + "95 64\r\n" + "17 47 82\r\n" + "18 35 87 10\r\n"
            + "20 04 82 47 65\r\n" + "19 01 23 75 03 34\r\n" + "88 02 77 73 07 63 67\r\n"
            + "99 65 04 28 06 16 70 92\r\n" + "41 41 26 56 83 40 80 70 33\r\n" + "41 48 72 33 47 32 37 16 94 29\r\n"
            + "53 71 44 65 25 43 91 52 97 51 14\r\n" + "70 11 33 28 77 73 17 78 39 68 17 57\r\n"
            + "91 71 52 38 17 14 91 43 58 50 27 29 48\r\n" + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\r\n"
            + "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    public static void main(String[] args) {
        System.out.println(new Problem018().call());
    }

    @Override
    public String call() {
        int result = maximumPathSum();
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Using a Node class, find the heaviest path by summing the weight at each node recursively
            First build out the Node object by populating nodes
     */
    private int maximumPathSum() {
        String[] treeArrayString = TREE.replace("\r\n", " ").split(" ");
        int[] treeArrayInteger = new int[treeArrayString.length];
        for (int i = 0; i < treeArrayString.length; i++) {
            treeArrayInteger[i] = Integer.parseInt(treeArrayString[i]);
        }
        Node root = new Node(null);
        root = addRecursively(root, treeArrayInteger, 1, 0);

        return Library.getHeaviestPath(root);
    }

    private Node addRecursively(Node root, int[] values, int lengthOfLevel, int i) {
        if (i < values.length) {
            root = new Node(values[i]);
            root.setLeft(addRecursively(root.getLeft(), values, lengthOfLevel + 1, i + lengthOfLevel));
            root.setRight(addRecursively(root.getRight(), values, lengthOfLevel + 1, i + lengthOfLevel + 1));
        }
        return root;
    }
}
