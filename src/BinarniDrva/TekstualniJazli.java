package BinarniDrva;

import java.util.Scanner;

public class TekstualniJazli{
    public static void main(String[] args) {
        BTree<String> tree = new BTree<>();

        tree.makeRoot("apple");

        BNode<String> node1 = tree.addChild(tree.root, 1, "pear");

        BNode<String> node2 = tree.addChild(node1, 1, "peach");

        BNode<String> node3 = tree.addChild(tree.root, 2, "banana");

        BNode<String> node4 = tree.addChild(node3, 2, "orange");

        BNode<String> node5 = tree.addChild(node3, 2, "lemon");

        tree.inorder();

        System.out.println(tree.leaves());
    }
}
