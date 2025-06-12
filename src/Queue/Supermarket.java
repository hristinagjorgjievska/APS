package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Kupuvac{
    String ime;
    int artikli;

    public Kupuvac(String ime, int artikli) {
        this.ime = ime;
        this.artikli = artikli;
    }

    public String getIme() {
        return ime;
    }

    public int getArtikli() {
        return artikli;
    }
}
public class Supermarket {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        Queue<Kupuvac> redica = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String ime = cin.next();
            int artikli = cin.nextInt();

            Kupuvac k = new Kupuvac(ime, artikli);
            redica.add(k);
        }

        int limit = 3;
        while (!redica.isEmpty()){
            Kupuvac curr = redica.poll();
            if (curr.artikli >= 3){
                curr.artikli-=3;
            }
            else if (curr.artikli == 2){
                curr.artikli-=2;
            }
            else if (curr.artikli == 1){
                curr.artikli-=1;
            }

            if (curr.artikli == 0){
                System.out.println(curr.ime);
            }
            else {
                redica.add(curr);
            }
        }
    }
}
