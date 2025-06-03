package DLLzadaci;

import java.awt.*;
import java.util.*;

public class Termin2PrvKolokvium2019 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        DLL<Integer> list = new DLL<>();
        DLL<Integer> list2 = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list2.insertLast(cin.nextInt());
        }

        DLL<Integer> result = new DLL<>();

        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> tmp2 = list2.getFirst();

        while (tmp != null){
            if (tmp.element % 2 != 0){
                result.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }

        while (tmp2 != null){
            if (tmp2.element % 2 == 0){
                result.insertLast(tmp2.element);
            }
            tmp2 = tmp2.succ;
        }

        DLLNode<Integer> tmpResult = result.getFirst();

        while (tmpResult != null && tmpResult.succ != null){
            if (tmpResult.element > tmpResult.succ.element){
                int node = tmpResult.element;
                tmpResult.element = tmpResult.succ.element;
                tmpResult.succ.element = node;
            }
            tmpResult = tmpResult.succ;
        }

        System.out.println(result);

    }
}
