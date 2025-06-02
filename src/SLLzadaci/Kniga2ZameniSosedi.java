package SLLzadaci;

import java.util.Scanner;

public class Kniga2ZameniSosedi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp = list.getFirst();

        while (tmp != null && tmp.succ != null){
            Integer node = tmp.element;
            tmp.element = tmp.succ.element;
            tmp.succ.element = node;

            tmp = tmp.succ.succ;
        }

        System.out.println(list);
    }
}
