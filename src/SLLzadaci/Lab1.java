package SLLzadaci;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        SLL<String> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.next());
        }

        int L = cin.nextInt();

        SLLNode<String> tmp = list.getFirst();

        while (tmp != null){
            if (tmp.element.length() > L){
                SLLNode<String> outlier = new SLLNode<>("Outlier", tmp.succ);
                list.insertBefore(outlier.element, tmp);
            }
            tmp = tmp.succ;
        }

        System.out.println(list);
    }
}
