package DLLzadaci;

import java.util.Scanner;

public class PrevrtiJaListata {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        DLLNode<Integer> tmp = list.getFirst();
        DLL<Integer> pomosna = new DLL<>();
        while (tmp != null){
            if (tmp.element % 2 == 0){
                int num = list.delete(tmp);
                pomosna.insertFirst(num);
            }
            tmp = tmp.succ;
        }

        tmp = list.getFirst();
        while (tmp != null){
            if (tmp.element % 2 != 0){
                int num = list.delete(tmp);
                list.insertFirst(num);
            }
            tmp = tmp.succ;
        }

        System.out.println(pomosna + "<->" + list);
    }
}
