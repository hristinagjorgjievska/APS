package BinarniPrebaruvackiDrva;

import java.util.Scanner;

public class pomaliOdNode {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int n = cin.nextInt();
        int q = cin.nextInt();
        cin.nextLine();

        pomaliOdNode pomali = new pomaliOdNode();

        for (int i = 0; i < n+q; i++) {
            String []parts = cin.nextLine().split(" ");
            String action = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (action.equals("insert")){
                tree.insert(number);
            }
            else if (action.equals("ask")){
                System.out.println(pomali.broi(tree.getRoot(), number));
            }
        }
    }

    public int broi(BNode<Integer> node, int number){

        if (node == null){
            return 0;
        }

        while (node != null){
            int count = 0;
            if (node.info < number){
                count++;
            }
            return count + broi(node.left, number) + broi(node.right, number);
        }
        return -1;
    }
}
