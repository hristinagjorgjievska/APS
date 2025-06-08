package BinarniPrebaruvackiDrva;

import java.util.Scanner;

public class pogolemiOdNode {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        pogolemiOdNode pogolemi = new pogolemiOdNode();

        int n = cin.nextInt();
        int q = cin.nextInt();
        cin.nextLine();

        for (int i = 0; i < n+q; i++) {
            String []parts = cin.nextLine().split(" ");
            String action = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (action.equals("insert")){
                tree.insert(number);
            }
            else if (action.equals("ask")){
                System.out.println(pogolemi.pogolemi(tree.getRoot(), number));
            }
        }
    }

    public int pogolemi(BNode<Integer> node, int number) {
        if (node == null) {
            return 0;
        }
        while (node != null) {
            int count = 0;
            if (node.info > number) {
                count++;
            }
            return count + pogolemi(node.left, number) + pogolemi(node.right, number);
        }
        return -1;
    }
}
