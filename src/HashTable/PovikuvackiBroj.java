package HashTable;

import java.util.Scanner;

public class PovikuvackiBroj {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, String> map = new CBHT<>(n*2);

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String broj = parts[0];
            String drzava = parts[1];

            map.insert(broj, drzava);
        }
        
        String broj = cin.next();
        if (broj.startsWith("+2")){
            broj = broj.substring(1,3);
        }
        else if (broj.startsWith("+3")){
            broj = broj.substring(1,4);
        }

        SLLNode<MapEntry<String, String>> result = map.search(broj);

        if (result == null){
            System.out.println("Nema takov povikuvacki broj");
        }
        else {
            System.out.println(result.element.value);
        }

    }
}
