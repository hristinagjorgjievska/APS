package HashTable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

class Vraboten implements Comparable<Vraboten> {
    String ime;
    String prezime;
    String datum;

    public Vraboten(String ime, String prezime, String datum) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public int compareTo(Vraboten o) {
        return 0;
    }
}

public class RodendeniOBHT{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, ArrayList<Vraboten>> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Vraboten v = new Vraboten(cin.next(), cin.next(), cin.next());
            String celoIme = v.getIme() + " " + v.getPrezime();

            String []datum = v.getDatum().split("/");
            String den = datum[0] + "/" + datum[1];


            if (map.search(den) == null){
                ArrayList<Vraboten> list = new ArrayList<>();
                list.add(v);
                map.insert(den, list);
            }else {
                ArrayList<Vraboten> list = map.search(den).element.value;
                list.add(v);
                map.insert(den, list);
            }
        }

        String datum = cin.next();
        String []parts = datum.split("/");
        String find = parts[0] + "/" + parts[1];
        int year = Integer.parseInt(parts[2]);
        SLLNode<MapEntry<String, ArrayList<Vraboten>>> result = map.search(find);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            ArrayList<Vraboten> lista = result.element.value;

            for (Vraboten v : lista){
                int godini = year - Integer.parseInt(v.getDatum().split("/")[2]);
                System.out.println(v.getIme() + " " + v.getPrezime() + " " + godini);
            }
        }
    }
}
