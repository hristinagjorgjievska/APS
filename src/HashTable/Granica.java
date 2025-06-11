package HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patnik{
    String broj;
    String ime;

    public Patnik(String broj, String ime) {
        this.broj = broj;
        this.ime = ime;
    }

    public String getBroj() {
        return broj;
    }

    public String getIme() {
        return ime;
    }
}
public class Granica{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, String> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Patnik p = new Patnik(cin.next(), cin.next());

            map.insert(p.getBroj(), p.getIme());

        }

        int num = cin.nextInt();
        cin.nextLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = cin.nextLine().split(" ");
            String staroIme = input[0];
            list.add(staroIme);
        }


        String pasos = cin.next();
        SLLNode<MapEntry<String, String>> result = map.search(pasos);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            if (list.contains(result.element.value)){
                System.out.println("Not Allowed");
            }
            else {
                System.out.println("Allowed");
            }
        }
    }
}
