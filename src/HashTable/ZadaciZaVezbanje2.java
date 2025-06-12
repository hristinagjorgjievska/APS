package HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patnici{
    String ime;
    String prezime;
    int budzet;
    String ipAddress;
    String vreme;
    String grad;
    int cena;

    public Patnici(String ime, String prezime, int budzet, String ipAddress, String vreme, String grad, int cena) {
        this.ime = ime;
        this.prezime = prezime;
        this.budzet = budzet;
        this.ipAddress = ipAddress;
        this.vreme = vreme;
        this.grad = grad;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBudzet() {
        return budzet;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getVreme() {
        return vreme;
    }

    public String getGrad() {
        return grad;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString(){
        return ime + " " + prezime + " with salary " + budzet + " from address " + ipAddress + " who spent " + cena;

    }
}
public class ZadaciZaVezbanje2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, List<Patnici>> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String ime = cin.next();
            String prezime = cin.next();
            int budzet = cin.nextInt();
            String ipAddress = cin.next();
            String vreme = cin.next();
            String grad = cin.next();
            int cena = cin.nextInt();

            Patnici p = new Patnici(ime, prezime, budzet, ipAddress, vreme, grad, cena);

            if (map.search(p.getGrad()) == null){
                List<Patnici> list = new ArrayList<>();
                list.add(p);
                map.insert(p.getGrad(), list);
            }
            else {
                SLLNode<MapEntry<String, List<Patnici>>> tmp = map.search(p.getGrad());
                List<Patnici> list = tmp.element.value;
                list.add(p);
                map.insert(p.getGrad(), list);
            }
        }

        int m = cin.nextInt();
        cin.nextLine();

        for (int i = 0; i < m; i++) {
            String ime = cin.next();
            String prezime = cin.next();
            int budzet = cin.nextInt();
            String ipAddress = cin.next();
            String vreme = cin.next();
            String grad = cin.next();
            int cena = cin.nextInt();

            //System.out.println(ime + " " + prezime + " " + budzet + " " + ipAddress + " " + vreme + " " + grad + " " + cena);

            SLLNode<MapEntry<String, List<Patnici>>> result = map.search(grad);
            if (!(result == null)){
                List<Patnici> list = result.element.value;
                System.out.println("City: " + grad + " has the following number of customers:");
                int count = 0;
                List<Patnici> podBudzet = new ArrayList<>();
                for (Patnici p : list){
                    if (p.budzet >= p.cena){
                        podBudzet.add(p);
                        count++;
                    }
                }
                System.out.println(count);
                System.out.println("The user who spent the most purchasing for that city is: ");
                Patnici max = null;
                int maxCena = -1;
                for (Patnici p : podBudzet){
                    if (p.getCena() > maxCena){
                        maxCena = p.getCena();
                        max = p;
                    }
                }
                if (max != null) {
                    System.out.println(max.toString());
                }
                System.out.println("");
            }
        }
    }
}
