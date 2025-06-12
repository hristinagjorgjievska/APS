package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    String ime;
    int baranja;

    public Person(String ime, int baranja) {
        this.ime = ime;
        this.baranja = baranja;
    }

    public String getIme() {
        return ime;
    }

    public int getBaranja() {
        return baranja;
    }
}
public class VleznaPrvKolokvium {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        Queue<Person> redica = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = cin.nextLine().split(" ");
            String ime = input[0];
            int baranja = Integer.parseInt(input[1]);

            Person p = new Person(ime, baranja);
            redica.add(p);
        }

        while (!redica.isEmpty()){ //dodeka redicata ne e prazna
            Person curr = redica.poll(); //go vadime prviot covek od redicata
            curr.baranja--; //baranjata mu gi namaluvame za 1

            if (curr.baranja == 0){ //ako baranjata se 0
                System.out.println(curr.ime); //pecati go imeto
            }
            else {
                redica.add(curr); //ako ima uste baranja, vrati go vo redicata
            }
        }
    }
}
