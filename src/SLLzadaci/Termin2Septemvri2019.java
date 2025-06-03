package SLLzadaci;

import java.util.Scanner;

public class Termin2Septemvri2019 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }
        int x = cin.nextInt();

        System.out.println(list);

        SLLNode<Integer> tmp = list.getFirst();
        SLL<Integer> lowerThanX = new SLL<>();

        int count = 0;
        while (tmp != null){
            if (tmp.element < x){
                Integer node = list.delete(tmp);
                lowerThanX.insertLast(node);
                count++;
            }
            tmp = tmp.succ;
        }

        if (count == n){
            System.out.println(lowerThanX);
        }
        else if (count == 0){
            System.out.println(list);
        }
        else {
            System.out.println(lowerThanX + "->" + list);
        }
    }
}
