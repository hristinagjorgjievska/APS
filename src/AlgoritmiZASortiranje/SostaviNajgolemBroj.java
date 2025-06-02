package AlgoritmiZASortiranje;

import java.util.Arrays;
import java.util.Scanner;

public class SostaviNajgolemBroj {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 0){
                count++;
            }
        }

        Arrays.sort(array);
        long sum = 0;
        if (count == n){
            for (int i = 0; i < n; i++) {
                System.out.print("0");
            }
        }
        else {
            for (int i = n - 1; i >= 0; i--) {
                sum = (sum * 10) + array[i];
            }
            System.out.println(sum);
        }

    }
}
