package BinarniPrebaruvackiDrva;

import java.util.Scanner;

public class BrisenjeJazolSoDveDeca {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();


        for (int i = 0; i < n; i++) {
            tree.insert(cin.nextInt());
        }

        System.out.println("Drvoto pred brisenje na jazolot so vrednost 8");
        tree.printTree();

        tree.remove(8);

        System.out.println("");
        System.out.println("Drvoto po brisenje na jazolot so vrednost 8");
        tree.printTree();

    }
}
