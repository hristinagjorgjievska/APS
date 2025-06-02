package DLLzadaci;

import java.util.Scanner;

public class Zadaca12 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }
        int k = cin.nextInt();

        System.out.println(list);

        for (int i = 0; i < k; i++) {
            Integer node = list.deleteFirst();
            list.insertLast(node);
        }

        System.out.println(list);
    }
}
