package SLLzadaci;

import java.util.Scanner;

public class ZameniSosedi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp = list.getFirst();

        while (tmp != null && tmp.succ != null){
            int num = tmp.element; //vo nova promenliva ja stavame tmp vrednosta(1)
            tmp.element = tmp.succ.element; //na mestoto na tmp go stavame tmp.succ (2)
            tmp.succ.element = num; //na mestotot na tmp.succ go stavame tmp (1)
            tmp = tmp.succ.succ; //tmp se pomestuva za 2 mesta za da pocne so naredniot par (3-4)
        }

        System.out.println(list);
    }
}
