package DLLzadaci;

import java.util.Scanner;

public class ListaOdListi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();

        long fullSum = 1;
        for (int i = 0; i < n; i++) {
            DLL<Integer> list = new DLL<>();
            long sum = 0;
            for (int j = 0; j < m; j++) {
                Integer node = cin.nextInt();
                list.insertLast(node);
                sum += node;
            }
            fullSum *= sum;
        }

        System.out.println(fullSum);
    }
}
