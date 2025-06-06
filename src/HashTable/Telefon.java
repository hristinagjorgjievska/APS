package HashTable;

import java.util.Scanner;

public class Telefon {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, String> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String broj = parts[0];
            String ime = parts[1];

            map.insert(broj, ime);
        }

        String broj = cin.next();
        if (broj.startsWith("+389")) {
            broj = 0 + broj.substring(4);
        }
        SLLNode<MapEntry<String, String>> result = map.search(broj);

        if (result == null){
            System.out.println("Unknown number");
        }
        else {
            System.out.println(result.element.value);
        }
    }
}
