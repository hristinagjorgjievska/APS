package SLLzadaci;

import java.util.Scanner;

public class Lista2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmpPrv = list.getFirst();

        System.out.println(tmpPrv.element);

        list.mirror();

        SLLNode<Integer> tmpPosleden = list.getFirst();

        System.out.println(tmpPosleden.element);

        int node = tmpPrv.element;
        tmpPrv.element = tmpPosleden.element;
        tmpPosleden.element = node;

        list.mirror();
        System.out.println(list);
    }
}
