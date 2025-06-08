package BinarniPrebaruvackiDrva;

import java.util.Scanner;

public class LabDoma {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        String []input = cin.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        LabDoma dlabocina = new LabDoma();

        for (int i = 0; i < n+q; i++) {
            String []parts = cin.nextLine().split(" ");
            String action = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (action.equals("insert")){
                tree.insert(number);
            }
            else if (action.equals("ask")){
                System.out.println(1 + dlabocina.dlabocina(tree.getRoot(), number));
            }
        }

    }

    public int dlabocina(BNode<Integer> node, int number){
        int dlabocina = 0;

        while (node != null){
            if (number == node.info){ //ako vrednosta na node e ista so vrednosta na brojot koj go barame
                return dlabocina;
            }

            if (number < node.info){ //ako brojot sto go barame e pomal od vrednosta na node, odime vo levo poddrvo
                node = node.left;
            }
            else {
                node = node.right; //ako e pogolem, prodolzuvame vo desno poddrvo
            }
            dlabocina++;
        }
        return dlabocina;
    }

}
