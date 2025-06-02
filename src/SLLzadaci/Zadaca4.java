package SLLzadaci;

import java.util.Scanner;

public class Zadaca4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<String> list = new SLL<String>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.next());
        }
        int L = cin.nextInt();
        System.out.println(list);

        SLLNode<String> tmp = list.getFirst();

       while (tmp != null){
           if (tmp.element.length() > L){
               list.insertBefore("Outlier", tmp);
           }
           tmp = tmp.succ;
       }

        System.out.println(list);
    }
}
