package HashTable;

import java.util.Scanner;

public class BrojRodendeni {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Integer> map = new CBHT<>(n*2);
        for (int i = 0; i < n; i++) {
            String parts[] = cin.nextLine().split("\\.");

            if (map.search(parts[1]) == null){ //proveruvame dali mesecot go ima vo mapata
                map.insert(parts[1], 1); //go stavame mesecot, i 1 vrednost deka 1 e vnesen
            }
            else { //ako go ima mesecot vo mapata
                SLLNode<MapEntry<String, Integer>> tmp = map.search(parts[1]); //go stavame mesecot vo promenliva tmp
                map.insert(parts[1], tmp.element.value + 1); //i potoa vrednosta za nego se zgolemuva za 1
            }
        }
        String month = cin.nextLine();
        SLLNode<MapEntry<String, Integer>> result = map.search(month); //vo mapata go barame mesecot (key) i go stavame vo promenliva
        if (result == null){
            System.out.println("Nema rodendeni vo toj mesec");
        }
        else {
            System.out.println(result.element.value); //ako ima, ja pecatime value (counterot)
        }

    }
}
