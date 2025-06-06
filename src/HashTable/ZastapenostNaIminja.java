package HashTable;

import java.util.*;

class Person {
    String ime;
    String pol;

    public Person(String ime, String pol) {
        this.ime = ime;
        this.pol = pol;
    }

    public String getIme() {
        return ime;
    }

    public String getPol() {
        return pol;
    }

    private int hash(Integer key) {
        char c1 = ime.charAt(0);
        char c2 = ime.charAt(1);
        int hash = (100 * (int)c1 + (int)c2 % 9091);
        return hash;
    }
}

public class ZastapenostNaIminja {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Integer> zenski = new CBHT<>(n);
        CBHT<String, Integer> maski = new CBHT<>(n);
        ArrayList<String> zenskiIminja = new ArrayList<>();
        ArrayList<String> maskiIminja = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Person p = new Person(cin.next(), cin.next());

            String ime = p.getIme().toUpperCase();
            if (p.getPol().equals("F")) {
                zenskiIminja.add(ime);

                if (zenski.search(ime) == null) {
                    zenski.insert(ime, 1);
                } else {
                    SLLNode<MapEntry<String, Integer>> tmp = zenski.search(ime);
                    zenski.insert(ime, tmp.element.value + 1);
                }
            } else {
                maskiIminja.add(ime);

                if (maski.search(ime) == null) {
                    maski.insert(ime, 1);
                } else {
                    SLLNode<MapEntry<String, Integer>> tmp = maski.search(ime);
                    maski.insert(ime, tmp.element.value + 1);
                }
            }
        }

        String pol = cin.next().toUpperCase();
        while (true) {
            String line = cin.next();
            if (line.equals("END"))
                break;

            line = line.toUpperCase();
            String first = line.substring(0, 2);

            if (pol.equals("F")) {
                SLLNode<MapEntry<String, Integer>> result = zenski.search(line);
                if (result == null) {
                    for (String ime : zenskiIminja) {
                        if (ime.startsWith(first)) {
                            System.out.println(ime);
                        }
                    }
                    System.out.println("No such name");
                } else {
                    System.out.println(pol + " " + result.element.key + " " + result.element.value);
                }
            } else if (pol.equals("M")) {
                SLLNode<MapEntry<String, Integer>> result = maski.search(line);
                if (result == null) {
                    for (String ime : maskiIminja) {
                        if (ime.startsWith(first)) {
                            System.out.println(ime);
                        }
                    }
                    System.out.println("No such name");
                } else {
                    System.out.println(pol + " " + result.element.key + " " + result.element.value);
                }
            }
        }
    }
}
