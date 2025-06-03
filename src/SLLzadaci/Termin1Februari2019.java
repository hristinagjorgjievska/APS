package SLLzadaci;

import java.util.Scanner;

public class Termin1Februari2019 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list1 = new SLL<>();
        SLL<Integer> list2 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(cin.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list2.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp1 = list1.getFirst();
        int sum1 = 0;
        while (tmp1 != null){
            sum1 = (sum1 * 10) + tmp1.element;
            tmp1 = tmp1.succ;
        }

        SLLNode<Integer> tmp2 = list2.getFirst();
        int sum2 = 0;
        while (tmp2 != null){
            sum2 = (sum2 * 10) + tmp2.element;
            tmp2 = tmp2.succ;
        }

        System.out.println(sum1+sum2);
    }
}
