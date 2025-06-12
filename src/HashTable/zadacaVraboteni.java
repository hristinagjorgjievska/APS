package HashTable;

import java.util.Scanner;

class Vraboteni implements Comparable<Vraboteni> {
    String ime;
    int vozrast;

    public Vraboteni(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    public String getIme() {
        return ime;
    }

    public int getVozrast() {
        return vozrast;
    }

    @Override
    public int compareTo(Vraboteni o) {
        return this.ime.compareTo(o.ime);
    }

    @Override
    public boolean equals(Object o) {
        Vraboteni v = (Vraboteni) o;
        return ime.equals(v.ime) && vozrast == v.vozrast;
    }

    @Override
    public String toString(){
        return "<" + ime + ", " + vozrast + ">";
    }

    @Override
    public int hashCode() {
        return getVozrast() * ime.charAt(0);
    }
}

class Proekt{
    int vreme;
    int plata;

    public Proekt(int vreme, int plata) {
        this.vreme = vreme;
        this.plata = plata;
    }

    public int getVreme() {
        return vreme;
    }

    public int getPlata() {
        return plata;
    }

    public int getVkupnaPlata(){
        return getPlata() * getVreme();
    }

    @Override
    public String toString(){
        return "<" + vreme + ", " + plata + ">";
    }
}
public class zadacaVraboteni {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        CBHT<Vraboteni, Proekt> map = new CBHT<>(10);

        for (int i = 0; i < n; i++) {
            String ime = cin.next();
            int godini = cin.nextInt();
            int casovi = cin.nextInt();
            int plata = cin.nextInt();

            Vraboteni v = new Vraboteni(ime, godini);
            Proekt p = new Proekt(casovi, plata);

            if (map.search(v) == null){
                map.insert(v, p);
            }
            else {
                SLLNode<MapEntry<Vraboteni, Proekt>> tmp = map.search(v);
                if (p.getVkupnaPlata() > tmp.element.value.getVkupnaPlata()){
                    map.insert(v, p);
                }
            }

        }

        System.out.println(map);

    }
}