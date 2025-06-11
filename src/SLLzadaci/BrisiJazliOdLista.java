package SLLzadaci;

import java.util.Scanner;

public class BrisiJazliOdLista {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(cin.nextInt());
        }

        SLLNode<Integer> tmp = list.getFirst(); //go zimame prviot jazol

        int count = 1; //pocnuvame od 1 bidejki prviot pat treba da se brise preku 1
        while (true){
            SLLNode<Integer> curr = tmp; //vo promenliva ja cuvame tmp
            for (int i = 0; i < count; i++) { //za pr count=1, tmp ke se pomesti eden pat
                if (curr == null) //ako curr ni e 0 (sme dosle do kraj)
                    break; //prestani so izvrsuvanje
                curr = curr.succ; //ako ne premini na sledniot jazol
            }

            if (curr == null)  //ako curr ni e null
                break; //iskoci od ciklusot

            list.delete(curr); //ako ne, brisi go curr
            tmp = tmp.succ; //pomesti go tmp za 1
            count++; //zgolemi go counterot
        }

        System.out.println(list);
    }
}
