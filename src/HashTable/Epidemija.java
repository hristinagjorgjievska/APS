package HashTable;

import java.util.Scanner;

class Pacient {
    String opstina;
    String prezime;
    String rezultat;

    public Pacient(String opstina, String prezime, String rezultat) {
        this.opstina = opstina;
        this.prezime = prezime;
        this.rezultat = rezultat;
    }

    public String getOpstina() {
        return opstina;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getRezultat() {
        return rezultat;
    }
}

public class Epidemija {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Integer> pozitivni = new CBHT<>(n);
        CBHT<String, Integer> negativni = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Pacient p = new Pacient(cin.next(), cin.next(), cin.next());

            if (p.getRezultat().equals("positive")) {
                if (pozitivni.search(p.getOpstina()) == null) {
                    pozitivni.insert(p.getOpstina(), 1);
                } else {
                    SLLNode<MapEntry<String, Integer>> tmp = pozitivni.search(p.getOpstina());
                    pozitivni.insert(p.getOpstina(), tmp.element.value + 1);
                }
            } else {
                if (negativni.search(p.getOpstina()) == null) {
                    negativni.insert(p.getOpstina(), 1);
                } else {
                    SLLNode<MapEntry<String, Integer>> tmp = negativni.search(p.getOpstina());
                    negativni.insert(p.getOpstina(), tmp.element.value + 1);
                }
            }
        }

        String opstina = cin.next();
        SLLNode<MapEntry<String, Integer>> resultPositive = pozitivni.search(opstina);
        SLLNode<MapEntry<String, Integer>> resultNegative = negativni.search(opstina);

        int positive = 0;
        if (resultPositive != null) {
            positive = resultPositive.element.value;
        }

        int negative = 0;
        if (resultNegative != null) {
            negative = resultNegative.element.value;
        }
        double sum = 0;

        if ((positive + negative) == 0){
            System.out.println("0.00");
        }
        else if (positive != 0 && negative != 0){
            sum = (double) positive / (positive + negative);
            System.out.printf("%.2f\n", sum);
        }
        else if (positive != 0 && negative == 0){
            System.out.println("1.00");
        }
        else if (negative != 0 && positive == 0){
            System.out.println("0.00");
        }
    }
}