package HashTable;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrami {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Integer> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String anagram = cin.nextLine();
            char[] a = anagram.toCharArray();
            Arrays.sort(a);
            String sortedAnagram = new String(a);

            if (map.search(sortedAnagram) == null){
                map.insert(sortedAnagram, 1);
            }
            else{
                SLLNode<MapEntry<String, Integer>> tmp = map.search(sortedAnagram);
                map.insert(sortedAnagram, tmp.element.value + 1);
            }
        }

        String anagram = cin.next();
        SLLNode<MapEntry<String, Integer>> result = map.search(anagram);
        if (result == null){
            System.out.println("Empty");
        }
        else {
            System.out.println(result.element.value);
        }
    }
}
