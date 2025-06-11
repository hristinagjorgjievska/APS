package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Kol{
    String datum;
    String vreme;
    String mesto;
    String predmet;

    public Kol(String datum, String vreme, String mesto, String predmet) {
        this.datum = datum;
        this.vreme = vreme;
        this.mesto = mesto;
        this.predmet = predmet;
    }

    public String getDatum() {
        return datum;
    }

    public String getVreme() {
        return vreme;
    }

    public String getMesto() {
        return mesto;
    }

    public String getPredmet() {
        return predmet;
    }
}
public class IspitnaSesija{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, List<Kol>> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String datum = cin.next();
            String vreme = cin.next();
            String mesto = cin.next();
            String predmet = cin.nextLine();

            Kol k = new Kol(datum, vreme, mesto, predmet);

            if (map.search(datum) == null){
                List<Kol> list = new ArrayList<>();
                list.add(k);
                map.insert(datum, list);
            }
            else {
                SLLNode<MapEntry<String, List<Kol>>> tmp = map.search(datum);
                List<Kol> list = tmp.element.value;
                list.add(k);
                map.insert(datum, list);
            }
        }

        String datum = cin.next();
        SLLNode<MapEntry<String, List<Kol>>> result = map.search(datum);

        if (result == null){
            System.out.println("nema ispiti na toj den");
        }
        else {
            List<Kol> list = result.element.value;
            list.sort((a, b) -> a.getVreme().compareTo(b.getVreme()));
            for (Kol k : list){
                System.out.println(k.getVreme() + " " + k.getMesto() + " " + k.getPredmet());
            }
        }

    }
}