package HashTable;

import java.util.Scanner;

public class TelefonskiImenik {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, String> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String []parts = cin.nextLine().split(" ");
            String telefon = parts[0];
            String ime = parts[1];

            if (map.search(telefon) == null){
                map.insert(telefon, ime);
            }
            else {
                SLLNode<MapEntry<String, String>> tmp = map.search(telefon);
                map.insert(telefon, ime);
            }
        }

        String telefon = cin.next();
        if (telefon.startsWith("+389")){
            telefon = 0 + telefon.substring(4);
        }
        SLLNode<MapEntry<String, String>> result = map.search(telefon);

        if (result ==  null){
            System.out.println("Unknown number");
        }
        else {
            System.out.println(result.element.value);
        }

    }
}
