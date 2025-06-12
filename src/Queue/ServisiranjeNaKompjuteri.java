package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Korisnik{
    String ime;
    int problemi;

    public Korisnik(String ime, int problemi) {
        this.ime = ime;
        this.problemi = problemi;
    }

    public String getIme() {
        return ime;
    }

    public int getProblemi() {
        return problemi;
    }
}

public class ServisiranjeNaKompjuteri {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        Queue<Korisnik> redica = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = cin.nextLine().split(" ");
            String ime = input[0];
            int problemi = Integer.parseInt(input[1]);

            Korisnik k = new Korisnik(ime, problemi);
            redica.add(k);
        }

        while (!redica.isEmpty()){
            Korisnik curr = redica.poll(); //go proveruvame prviot korisnik
            curr.problemi--;

            if (curr.problemi == 0){
                System.out.println(curr.ime);
            }
            else {
                redica.add(curr);
            }
        }
    }
}
