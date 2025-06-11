package SLLzadaci;

import java.util.Arrays;
import java.util.Scanner;

public class PreurediLista {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp = list.getFirst();

        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();

        int max = 0;
        int min = 999999;
        while (tmp != null){
            if (tmp.element > max){
                max = tmp.element;
            }
            if (tmp.element < min){
                min = tmp.element;
            }
            tmp = tmp.succ;
        }

        tmp = list.getFirst();

        while (tmp != null){
            if (Math.abs(tmp.element-max) >= Math.abs(tmp.element-min)){
                pomali.insertLast(tmp.element);
            }
            else {
                pogolemi.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }

        System.out.println(pomali);
        System.out.println(pogolemi);
    }
}
