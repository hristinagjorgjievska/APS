package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RodendeniOdKniga {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, ArrayList<String>> map = new CBHT<>(n);
        String[] niza;

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String ime = parts[0];
            String mesec = parts[1];
            if(mesec.length() == 9){
                mesec = mesec.substring(3,4);
            }
            else if (mesec.length() == 8){
                mesec = mesec.substring(2,3);
            }

            ArrayList<String> list = new ArrayList<>();
            if (map.search(mesec) == null){
                list.add(ime);
                map.insert(mesec, list);
            }
            else {
                SLLNode<MapEntry<String, ArrayList<String>>> tmp = map.search(mesec);
                if (!(tmp.element.value.contains(ime))) {
                    tmp.element.value.add(ime);
                }
            }
        }

        String mesec = cin.next();
        SLLNode<MapEntry<String, ArrayList<String>>> result = map.search(mesec);

        if (result == null){
            System.out.println("Empty");
        }
        else {
            System.out.println(String.join(" ", result.element.value));
        }
    }
}
