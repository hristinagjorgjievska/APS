package BinarniDrva;

import java.util.Scanner;

public class ProveriDaliPostoi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>();

        tree.makeRoot(19);
        BNode<Integer> node1 = tree.addChild(tree.root, 1, 15);
        BNode<Integer> node2 = tree.addChild(node1, 1, 9);
        BNode<Integer> node3 = tree.addChild(node2, 1, 1);
        BNode<Integer> node4 = tree.addChild(node3, 2, 11);
        BNode<Integer> node5 = tree.addChild(node4, 1, 6);
        BNode<Integer> node6 = tree.addChild(node5, 2, 5);
        BNode<Integer> node7 = tree.addChild(node6, 1, 7);
        BNode<Integer> node8 = tree.addChild(node7, 2, 2);

        int number = cin.nextInt();
        System.out.println(najdiBroj(tree.root, number));
    }

    public static boolean najdiBroj(BNode<Integer> node, int number){
        if (node == null){
            return false;
        }

        if (node.info == number){
            return true;
        }

        //prebaruvaj i levo i desno dete na daden node
        return najdiBroj(node.left, number) || najdiBroj(node.right, number);
    }
}
