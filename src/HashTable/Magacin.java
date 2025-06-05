package HashTable;

import java.util.Map;
import java.util.Scanner;

public class Magacin {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, MapEntry<String, Integer>> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split("@");
            String name = parts[0];
            String usedFor = parts[1];
            int price = Integer.parseInt(parts[2]);

            if (map.search(usedFor) == null){
                map.insert(usedFor, new MapEntry<>(name, price));
            }
            else {
                SLLNode<MapEntry<String, MapEntry<String, Integer>>> tmp = map.search(usedFor);
                if (tmp.element.value.value > price){
                    map.insert(usedFor, new MapEntry<>(name, price));
                }
            }
        }

        String usedFor = cin.next();
        SLLNode<MapEntry<String, MapEntry<String, Integer>>> result = map.search(usedFor);

        if (result == null){
            System.out.println("No such medicine");
        }
        else {
            System.out.println(result.element.value.key);
        }
    }
}
