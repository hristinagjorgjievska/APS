package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalansiraniZagradi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true){
            String zagrada = cin.next();

            if (zagrada.equals("x"))
                break;

            if (zagrada.equals("(")){
                stack.push(zagrada);
            } else {
                if (stack.isEmpty()){
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
