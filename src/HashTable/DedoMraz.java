package HashTable;

import java.util.ArrayList;
import java.util.Scanner;

class Adresa{
    String ime;
    String ulica;
    String broj;

    public Adresa(String ime, String ulica, String broj) {
        this.ime = ime;
        this.ulica = ulica;
        this.broj = broj;
    }

    public String getIme() {
        return ulica;
    }

    public String getUlica() {
        return ulica;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String toString(){
        return ulica + " " + broj;
    }
}
public class DedoMraz {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, Adresa> map = new CBHT<>(n*2);
        ArrayList<String> deca = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String []input = cin.nextLine().split(" ");
            String ime = input[0];
            String ulica = input[1];
            String broj = input[2];

            Adresa a = new Adresa(ime, ulica, broj);

            map.insert(ime, a);
            deca.add(ime);
        }

        int m = cin.nextInt();
        cin.nextLine();

        for (int i = 0; i < m; i++) {
            String []input = cin.nextLine().split(" ");
            String staraAdresa = input[0];
            String novaAdresa = input[1];

            for (String dete : deca){
                SLLNode<MapEntry<String, Adresa>> tmp = map.search(dete);
                if (tmp.element.value.ulica.equals(staraAdresa)){
                    tmp.element.value.ulica = novaAdresa;
                }
            }

        }

        String ime = cin.next();
        SLLNode<MapEntry<String, Adresa>> result = map.search(ime);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            System.out.println(result.element.value.toString());
        }
    }
}
