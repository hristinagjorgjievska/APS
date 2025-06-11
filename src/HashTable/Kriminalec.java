package HashTable;

import java.util.Scanner;

class Primerok{
    String pr1;
    String pr2;

    public Primerok(String pr1, String pr2) {
        this.pr1 = pr1;
        this.pr2 = pr2;
    }

    public String getPr1() {
        return pr1;
    }

    public String getPr2() {
        return pr2;
    }
}


public class Kriminalec {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        CBHT<String, String> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String ime = cin.next();
            String pr1 = cin.next();
            String pr2 = cin.next();
            String primerok = pr1 + pr2;

            map.insert(primerok, ime);
        }

        String pr1 = cin.next();
        String pr2 = cin.next();

        String primerokDaden = pr1 + pr2;
        SLLNode<MapEntry<String, String>> result = map.search(primerokDaden);

        if (result == null){
            System.out.println("Unknown");
        }
        else {
            System.out.println(result.element.value);
        }

    }
}