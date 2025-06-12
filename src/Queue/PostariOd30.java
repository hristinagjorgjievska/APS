package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class User{
    String ime;
    int vozrast;

    public User(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    public String getIme() {
        return ime;
    }

    public int getVozrast() {
        return vozrast;
    }
}
public class PostariOd30 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Queue<User> queue = new LinkedList<>();

        int count = 0;
        while (true){
            String ime = cin.next();
            if (ime.equals("KRAJ"))
                break;

            int godini = cin.nextInt();

            User u = new User(ime, godini);
            queue.add(u);

            System.out.println("Корисник: " + u.getIme() + ", возраст: " + u.getVozrast());

            if (u.getVozrast() > 30){
                count++;
            }
        }

        System.out.println("Број на корисници постари од 30: " + count);


    }
}
