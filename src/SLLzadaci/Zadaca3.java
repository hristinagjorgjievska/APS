package SLLzadaci;

import java.util.Scanner;

public class Zadaca3 {
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
            if (tmp.element.length() == L){ //ako dolzinata na elementot e L
                SLLNode<String> target = new SLLNode<>("Target", tmp.succ); //pravime nov node so vrednost Target na elementot posle tmp
                tmp.succ = target; //sega tmp pokazuva na sledniot noviot node Target
                tmp = target.succ; //se premestuvame dva nodes ponapred za da mozeme da prodolzime (posle target)
            }
            else {
                tmp = tmp.succ;
            }
        }

        System.out.println(list);
    }
}
