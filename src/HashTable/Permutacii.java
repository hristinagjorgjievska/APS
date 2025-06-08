package HashTable;

import java.util.Arrays;
import java.util.Scanner;

public class Permutacii {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, Integer> map = new CBHT<>(n*2);

        for (int i = 0; i < n; i++) {
            String string = cin.nextLine();
            char[] s = string.toCharArray();
            Arrays.sort(s);
            String sortedString = new String(s);

            if (map.search(sortedString) == null){
                map.insert(sortedString, 1);
            }
            else {
                SLLNode<MapEntry<String, Integer>> tmp = map.search(sortedString);
                map.insert(tmp.element.key, tmp.element.value + 1);
            }
        }

        String string = cin.next();
        char []s = string.toCharArray();
        Arrays.sort(s);
        String sortedString = new String(s);

        SLLNode<MapEntry<String, Integer>> result = map.search(sortedString);
        if (result == null){
            System.out.println("Empty");
        }
        else {
            System.out.println(result.element.value);
        }
    }
}
