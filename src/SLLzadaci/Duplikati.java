package SLLzadaci;

import java.util.Scanner;

public class Duplikati {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        int k = cin.nextInt();

        SLLNode<Integer> tmp = list.getFirst();

        int count = 0;

        while (tmp != null){
            if (tmp.element.equals(k)){
                count++;
            }
            tmp = tmp.succ;
        }

        tmp = list.getFirst();

        while (tmp != null){
            if (tmp.element.equals(k)){
                if (count % 2 == 0){
                    break;
                }
                else {
                    SLLNode<Integer> node = new SLLNode<>(tmp.element, tmp.succ);
                    tmp.succ = node;
                    tmp = node.succ;
                    break;
                }
            }
            tmp = tmp.succ;
        }

        System.out.println(count);

        System.out.println(list);
    }

}
