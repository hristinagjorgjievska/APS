package DLLzadaci;

import java.util.Scanner;

public class PodeliSporedProsek {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        DLLNode<Integer> tmp = list.getFirst();

        int sum = 0;
        double prosek = 0;

        while (tmp != null){
            sum += tmp.element;

            tmp = tmp.succ;
        }

        prosek = (double) sum / n;

        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();

        tmp = list.getLast();

        while (tmp != null){
            if (tmp.element <= prosek){
                pomali.insertLast(tmp.element);
            }
            else {
                pogolemi.insertLast(tmp.element);
            }
            tmp = tmp.pred;
        }

        System.out.println(pomali);
        System.out.println(pogolemi);
    }
}
