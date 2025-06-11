package HashTable;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Per{
    String ime;
    String prezime;
    String data;

    public Per(String ime, String prezime, String data) {
        this.ime = ime;
        this.prezime = prezime;
        this.data = data;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getData() {
        return data;
    }
}

public class RodendeniZadacaOdOBHT {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, List<Per>> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Per p = new Per(cin.next(), cin.next(), cin.next());

            String data = p.getData().substring(0, 5);
            if (map.search(data) == null){
                List<Per> list = new ArrayList<>();
                list.add(p);
                map.insert(data, list);
            }
            else{
                SLLNode<MapEntry<String, List<Per>>> tmp = map.search(data);
                List<Per> list = tmp.element.value;
                list.add(p);
                map.insert(tmp.element.key, list);
            }
        }

        String data = cin.next();
        String mesec = data.substring(0,5);
        int godina = Integer.parseInt(data.substring(6));

        SLLNode<MapEntry<String, List<Per>>> result = map.search(mesec);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            List<Per> list = result.element.value;
            for (Per p : list){
                int pGodini = Integer.parseInt(p.getData().substring(6));
                int godini = godina - pGodini;
                System.out.println(p.getIme() + " " + p.getPrezime() + " " + godini);
            }
        }
    }
}
