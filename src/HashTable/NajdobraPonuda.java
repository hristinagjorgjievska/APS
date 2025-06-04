package HashTable;

import java.util.Scanner;

class Predavac{
    String date;
    String time;
    String city;
    int offer;

    public Predavac(String date, String time, String city, int offer) {
        this.date = date;
        this.time = time;
        this.city = city;
        this.offer = offer;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCity() {
        return city;
    }

    public int getOffer() {
        return offer;
    }
}

public class NajdobraPonuda {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Predavac> map = new CBHT<>(n*2);
        for (int i = 0; i < n; i++) {
            Predavac p = new Predavac(cin.next(), cin.next(), cin.next(), cin.nextInt());

            if (map.search(p.getDate()) == null){
                map.insert(p.getDate(), p);
            }
            else {
                SLLNode<MapEntry<String, Predavac>> bestForDate = map.search(p.getDate());
                Predavac bestOffer = bestForDate.element.value;
                if (p.getOffer() > bestOffer.getOffer()){
                    map.insert(p.getDate(), p);
                }
            }
        }

        String date = cin.next();
        SLLNode<MapEntry<String, Predavac>> result = map.search(date);
        if (result == null){
            System.out.println("No offers");
        }
        else {
            Predavac best = result.element.value;
            System.out.println(best.getTime() + " " + best.getCity() + " " + best.getOffer());
        }
    }
}
