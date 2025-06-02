package DLLzadaci;

import java.util.Scanner;

public class Zadaca11 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }
        int k = cin.nextInt();

        System.out.println(list);

        DLL<Integer> newList = new DLL<>();

        int count = 0;
        for (int i = 0; i < k; i++) {
            Integer node = list.deleteLast();
            newList.insertFirst(node);
            count++;
        }

        if (k == n){
            System.out.println(newList);
        }
        else if (count == 0){
            System.out.println(list);
        }
        else {
            System.out.println(newList + "<->" + list);
        }
    }
}
