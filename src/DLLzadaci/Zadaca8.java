package DLLzadaci;

import java.util.Scanner;

public class Zadaca8 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        DLL<String> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.next());
        }
        int k = cin.nextInt();

        for (int i = 0; i < k; i++) {
            String node = list.deleteFirst();
            list.insertLast(node);
        }

        System.out.println(list);
    }


}
