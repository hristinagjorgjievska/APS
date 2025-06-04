package HashTable;
import java.util.Scanner;

public class KrvnaGrupa {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        OBHT<String, Integer> map = new OBHT<>(n*2);
        for (int i = 0; i < n; i++) {
            String name = cin.next();
            String bloodType = cin.next().replaceAll("[1-2]", " ");
            int bucket = map.search(bloodType);
            if (bucket == -1){
                map.insert(bloodType, 1);
            }
            else {
                map.insert(bloodType, map.getBucket(bucket).value + 1);
            }
        }

        System.out.println(map);
    }
}
