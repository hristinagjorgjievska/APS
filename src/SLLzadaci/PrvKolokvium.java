package SLLzadaci;

import java.util.Scanner;

public class PrvKolokvium {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        SLL<String> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.next());
        }

        System.out.println(list);

        SLLNode<String> tmp = list.getFirst();

        while (tmp != null){
            if (Character.isUpperCase(tmp.element.charAt(0))){
                String string = list.delete(tmp);
                list.insertFirst(string);
            }
            tmp = tmp.succ;
        }

        System.out.println(list);
    }
}
