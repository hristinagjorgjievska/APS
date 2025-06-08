package HashTable;

import java.util.ArrayList;
import java.util.Scanner;

class Ispit{
    String datum;
    String vreme;
    String prostorija;
    String predmet;

    public Ispit(String datum, String vreme, String prostorija, String predmet) {
        this.datum = datum;
        this.vreme = vreme;
        this.prostorija = prostorija;
        this.predmet = predmet;
    }

    public String getDatum() {
        return vreme;
    }

    public String getVreme() {
        return vreme;
    }

    public String getProstorija() {
        return prostorija;
    }

    public String getPredmet() {
        return predmet;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", datum, vreme, prostorija, predmet);
    }
}

public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, ArrayList<Ispit>> map = new CBHT<>(n*2);

        for (int i = 0; i < n; i++) {
            String line = cin.nextLine();
            String[] parts = line.split(" ");
            String datum = parts[0];
            String vreme = parts[1];
            String prostorija = parts[2];
            String predmet = parts[3];

            Ispit ispit = new Ispit(datum, vreme, prostorija, predmet);

            if (map.search(datum) == null) {
                ArrayList<Ispit> list = new ArrayList<>();
                list.add(ispit);
                map.insert(datum, list);
            }
            else {
                SLLNode<MapEntry<String, ArrayList<Ispit>>> tmp = map.search(datum);
                tmp.element.value.add(ispit);
            }
        }

        String datum = cin.next();
        SLLNode<MapEntry<String, ArrayList<Ispit>>> result = map.search(datum);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            for (Ispit i : result.element.value){
                System.out.println(i.toString());
            }
        }
    }
}
