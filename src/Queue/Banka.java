package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BankUser{
    String ime;
    int operacii;
    boolean priority;

    public BankUser(String ime, int operacii, boolean priority) {
        this.ime = ime;
        this.operacii = operacii;
        this.priority = priority;
    }

    public String getIme() {
        return ime;
    }

    public int getOperacii() {
        return operacii;
    }

    public boolean isPriority() {
        return priority;
    }
}
public class Banka {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        Queue<BankUser> priorityQ = new LinkedList<>();
        Queue<BankUser> nonPriorityQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            BankUser user = new BankUser(cin.next(), cin.nextInt(), cin.nextBoolean());
            if (user.priority){
                priorityQ.add(user);
            }
            else {
                nonPriorityQ.add(user);
            }
        }

        while (!priorityQ.isEmpty() || !nonPriorityQ.isEmpty()){ //ako edna od ovie ne ni e prazna
            BankUser user;

            if (!priorityQ.isEmpty()){ //ako imame prioriteten
                user = priorityQ.poll(); //ke go zememe nego
            }
            else {
                user = nonPriorityQ.poll(); //ako nema, obicen
            }

            user.operacii--; //gi namaluvame operaciite za 1

            if (user.operacii == 0){
                System.out.println(user.ime);
            }
            else {
                if (user.priority){ //ako ima prioritet, go vrakjame vo priority
                    priorityQ.add(user);
                }
                else {
                    nonPriorityQ.add(user); //ako ne, vo obicni
                }
            }
        }
    }
}
