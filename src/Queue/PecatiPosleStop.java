package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PecatiPosleStop {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Queue<String> redica = new LinkedList<>();

        while (true){
            String ime = cin.next();
            if (ime.equals("STOP")) {
                break;
            }

            redica.add(ime);
        }

        while (!redica.isEmpty()){
            System.out.println(redica.remove());
        }
    }
}
