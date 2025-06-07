package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalansiraniRazlicniZagradi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            String input = cin.next();

            if (input.equals("x"))
                break;

            if (input.equals("(")) {
                stack.push(input);
            } else if (input.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }

            if (input.equals("{")) {
                stack.push(input);
            } else if (input.equals("}")) {
                if (stack.isEmpty() || !stack.peek().equals("{")) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }

            if (input.equals("[")) {
                stack.push(input);
            } else if (input.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }

        }
        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
    }