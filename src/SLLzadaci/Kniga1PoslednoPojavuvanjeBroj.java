package SLLzadaci;

import java.util.List;
import java.util.Scanner;

public class Kniga1PoslednoPojavuvanjeBroj {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }
        int k = cin.nextInt();

        System.out.println(list);

        list.mirror();

        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null){
            if (tmp.element.equals(k)){
                list.delete(tmp);
                break;
            }
            tmp = tmp.succ;
        }

        list.mirror();
        System.out.println(list);
    }
}
