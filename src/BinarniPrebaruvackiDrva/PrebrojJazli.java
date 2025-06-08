package BinarniPrebaruvackiDrva;

public class PrebrojJazli {

    public int prebrojJazli(BNode<Integer> jazol){
        if (jazol == null){
            return 0;
        }

        return 1 + prebrojJazli(jazol.left) + prebrojJazli(jazol.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);

        PrebrojJazli count = new PrebrojJazli();
        System.out.println("Vkupno jazli: " + count.prebrojJazli(tree.getRoot()));

    }
}
