package HashTable;

import java.util.Scanner;

class Lek{
    String ime;
    int posNeg;
    int cena ;
    int kolicina;

    public Lek(String ime, int posNeg, int cena, int kolicina) {
        this.ime = ime;
        this.posNeg = posNeg;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public String getIme() {
        return ime;
    }

    public int getPosNeg() {
        return posNeg;
    }

    public int getCena() {
        return cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    private int hashCode(String key){
        return (100*(100*(100*0+ime.charAt(3)) + ime.charAt(2)) + ime.charAt(1))%656565;
    }
}
public class Apteka {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Lek> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Lek l = new Lek(cin.next(), cin.nextInt(), cin.nextInt(), cin.nextInt());

            if (map.search(l.getIme()) == null) {
                map.insert(l.ime, l);
            } else {
                SLLNode<MapEntry<String, Lek>> tmp = map.search(l.getIme());
                map.insert(l.ime, l);
            }
        }

        int kolicina = 0;
        while (true){
            String input = cin.next();
            if (input.equals("END")) {
                break;
            }
            kolicina = cin.nextInt();
            cin.nextLine();

            String lista = "";
            SLLNode<MapEntry<String, Lek>> result = map.search(input.toUpperCase());
            if (result == null){
                System.out.println("No such drug");
                continue;
            }
            else {
                if (kolicina <= result.element.value.getKolicina()){
                    if (result.element.value.getPosNeg() == 0){
                        lista = "NEG";
                    }
                    else {
                        lista = "POS";
                    }
                    System.out.println(result.element.key + " " + lista + " " + result.element.value.getCena() + " " + result.element.value.getKolicina());
                    System.out.println("Order made");
                }
                else {
                    System.out.println(result.element.key + " " + lista + " " + result.element.value.getCena() + " " + result.element.value.getKolicina());
                    System.out.println("No available amount");
                }
            }
        }
    }
}
