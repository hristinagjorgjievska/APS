package SLLzadaci;

import java.util.Scanner;

public class Zadaca6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<String> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.next());
        }
        int L = cin.nextInt();

        System.out.println(list);

        list.mirror();

        SLLNode<String> tmp = list.getFirst();
        SLL<String> newList = new SLL<>();
        int count = 0;
        while (tmp != null){
            if (tmp.element.length() == L){
                newList.insertLast(tmp.element);
                list.delete(tmp);
                count++;
                break;
            }
            tmp = tmp.succ;
        }

        list.mirror();
        if (count != 0){
            System.out.println(newList + "->" + list);
        }
        else {
            System.out.println(list);
        }
    }
}
