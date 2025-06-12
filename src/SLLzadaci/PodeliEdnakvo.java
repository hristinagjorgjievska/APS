package SLLzadaci;

import java.util.Scanner;

public class PodeliEdnakvo {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp = list.getFirst();

        int brojElementi = n / 10;
        int ostatok = n % 10;
        //System.out.println(brojElementi);
        //System.out.println(ostatok);


        System.out.print("[");
        if (ostatok != 0) {
            for (int i = 0; i < ostatok; i++) {
                SLL<Integer> list1 = new SLL<>();
                for (int j = 0; j < brojElementi + 1; j++) {
                    int num = list.deleteFirst();
                    list1.insertLast(num);
                }
                System.out.print(list1);
                if (i != ostatok - 1){
                    System.out.print(", ");
                }
            }
        }

        if (ostatok > 0) {
            System.out.print(", ");
        }
        for (int i = 0; i < 10-ostatok; i++) {
            SLL<Integer> list2 = new SLL<>();
            for (int j = 0; j < brojElementi; j++) {
                int num = list.deleteFirst();
                list2.insertLast(num);
            }
            System.out.print(list2);
            if (i != 10 - ostatok - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
