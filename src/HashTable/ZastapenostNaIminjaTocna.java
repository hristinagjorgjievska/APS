package HashTable;

import java.util.ArrayList;
import java.util.Scanner;

public class ZastapenostNaIminjaTocna {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, Integer> zenski = new CBHT<>(n);
        CBHT<String, Integer> maski = new CBHT<>(n);
        ArrayList<String> listZ = new ArrayList<>();
        ArrayList<String> listM = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String ime = parts[0];
            String pol = parts[1];

            if (pol.equals("F")){
                String upperName = ime.toUpperCase();
                SLLNode<MapEntry<String, Integer>> tmp = zenski.search(upperName);

                if (zenski.search(upperName) ==  null){
                    zenski.insert(upperName, 1);
                    listZ.add(upperName);
                }
                else {
                    zenski.insert(upperName, tmp.element.value + 1);
                }
            }
            else {
                String upperName = ime.toUpperCase();
                SLLNode<MapEntry<String, Integer>> tmp = maski.search(upperName);

                if (maski.search(upperName) ==  null){
                    maski.insert(upperName, 1);
                    listM.add(upperName);
                }
                else {
                    maski.insert(upperName, tmp.element.value + 1);
                }
            }
        }

        String pol = cin.next();

        while (true) {
            String ime = cin.next().toUpperCase();
            if (ime.equals("END")) {
                break;
            } else {
                if (pol.equals("F")) {
                    SLLNode<MapEntry<String, Integer>> result = zenski.search(ime.toUpperCase());
                    if (result == null) {
                        String[] niza = listZ.toArray(new String[0]);
                        for (int i = 0; i < niza.length; i++) {
                            if (niza[i].startsWith(ime.substring(0, 2))) {
                                System.out.println(niza[i]);
                            }
                        }

                        System.out.println("No such name");
                    } else {
                        String[] niza = listZ.toArray(new String[0]);
                        for (int i = 0; i < niza.length; i++) {
                            if (niza[i].startsWith(ime.substring(0, 2))) {
                                System.out.println(niza[i]);
                            }
                        }
                        System.out.println(pol + " " + ime + " " + result.element.value);
                    }
                }
                else {
                    SLLNode<MapEntry<String, Integer>> result = maski.search(ime);
                    if (result == null) {
                        String[] niza = listM.toArray(new String[0]);
                        for (int i = 0; i < niza.length; i++) {
                            if (niza[i].startsWith(ime.substring(0, 2))) {
                                System.out.println(niza[i]);
                            }
                        }
                        System.out.println("No such name");
                    } else {
                        String[] niza = listM.toArray(new String[0]);
                        for (int i = 0; i < niza.length; i++) {
                            if (niza[i].startsWith(ime.substring(0, 2))) {
                                System.out.println(niza[i]);
                            }
                        }
                        System.out.println(pol + " " + ime + " " + result.element.value);
                    }
                }
            }
        }

    }
}
