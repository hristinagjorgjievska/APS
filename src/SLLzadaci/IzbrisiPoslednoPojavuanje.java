package SLLzadaci;

import java.util.Scanner;

public class IzbrisiPoslednoPojavuanje {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        list.mirror();

        int k = cin.nextInt();

        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null){
            if (tmp.element == k){
                list.delete(tmp);
                break;
            }
            tmp = tmp.succ;
        }

        list.mirror();

        System.out.println(list);
    }
}
