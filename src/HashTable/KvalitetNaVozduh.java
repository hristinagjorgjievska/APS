package HashTable;

import java.util.ArrayList;
import java.util.Scanner;

public class KvalitetNaVozduh {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        OBHT<String, ArrayList<Double>> map = new OBHT<>(n);

        for (int i = 0; i < n; i++) {
            String []input = cin.nextLine().split(" ");
            String opstina = input[0];
            String pmCesticki = input[1];

            if (map.search(opstina) == -1){
                ArrayList<Double> list = new ArrayList<>();
                list.add(Double.parseDouble(pmCesticki));
                map.insert(opstina, list);
            }
            else {
                ArrayList<Double> postoecka = new ArrayList<>();
                postoecka = map.getBucket(map.search(opstina)).value;
                postoecka.add(Double.parseDouble(pmCesticki));
                map.insert(opstina, postoecka);
            }
        }

        String opstina = cin.next();
        ArrayList<Double> result = map.getBucket(map.search(opstina)).value;

        double sum = 0;

        if (result.size() == 0){
            System.out.println("No info");
        }
        else {
            for (int i = 0; i < result.size(); i++) {
                sum += result.get(i);
            }

            //System.out.println(sum/result.size());
            System.out.printf("%.2f\n", sum/result.size());
        }
    }
}
