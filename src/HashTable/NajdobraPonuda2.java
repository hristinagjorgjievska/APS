package HashTable;

import java.util.Scanner;
//printa samo key i value, bez klasa

public class NajdobraPonuda2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Integer> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String date = parts[0];
            String o = parts[3];
            int offer = Integer.parseInt(o);

            if (map.search(date) == null){
                map.insert(date, offer);
            }
            else {
                SLLNode<MapEntry<String, Integer>> tmp = map.search(date);
                if (offer > tmp.element.value){
                    map.insert(date, offer);
                }

            }

        }
        String date = cin.nextLine();
        SLLNode<MapEntry<String, Integer>> result = map.search(date);
        if (result == null){
            System.out.println("No offers");
        }
        else {
            System.out.println(result.element.key + " " + result.element.value);
        }
    }
}
