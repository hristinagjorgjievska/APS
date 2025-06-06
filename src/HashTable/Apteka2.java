package HashTable;

import java.util.Scanner;

class Lekovi{
    String ime;
    String lista;
    String cena;
    int kolicina;

    public Lekovi(String ime, String lista, String cena, int kolicina) {
        this.ime = ime;
        this.lista = lista;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public String getIme() {
        return ime;
    }

    public String getLista() {
        String lista = "";
        if (lista.equals("0")){
            lista = "NEG";
        }
        else {
            lista = "POS";
        }
        return lista;
    }

    public String getCena() {
        return cena;
    }

    public int getKolicina() {
        return kolicina;
    }
}
public class Apteka2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Lekovi> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Lekovi lek = new Lekovi(cin.next(), cin.next(), cin.next(), cin.nextInt());

            map.insert(lek.getIme(), lek);
        }

        String lek = "";
        int kolicina;
        while (true){
            lek = cin.next();
            String upperLek = lek.toUpperCase();
            kolicina = cin.nextInt();

            if (lek.equals("END"))
                break;

            SLLNode<MapEntry<String, Lekovi>> result = map.search(upperLek);
            if (result == null){
                System.out.println("No such drug");
            }
            else {
                if (kolicina <= result.element.value.getKolicina()){
                    System.out.println(result.element.key + " " + result.element.value.getLista() + " " + result.element.value.getCena() + " " + result.element.value.getKolicina());
                }
                System.out.println("Order made");
            }
        }
    }
}
