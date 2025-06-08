package BinarniPrebaruvackiDrva;

import java.util.Scanner;

public class PrebarajElement {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);


        int num = cin.nextInt();
        tree.find(num);

        if (tree.find(num) == null){
            System.out.println("Go nema " + num +  " vo drvoto");
        }
        else {
            System.out.println((tree.find(num).info));
        }
    }
}
