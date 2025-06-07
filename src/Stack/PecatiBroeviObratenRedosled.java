package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PecatiBroeviObratenRedosled {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        while (true){
            String input = cin.next();

            if (input.equals("x"))
                break;

            int number = Integer.parseInt(input);
            stack.push(number);
        }

        if (stack.isEmpty()){
            System.out.println("The stack is empty");
        }
        else {
            while (!(stack.isEmpty())){
                System.out.println(stack.pop());
            }
        }
    }
}
