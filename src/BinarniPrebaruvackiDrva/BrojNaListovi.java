package BinarniPrebaruvackiDrva;

public class BrojNaListovi {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);

        BrojNaListovi listovi = new BrojNaListovi();
        System.out.println(listovi.prebrojListovi(tree.getRoot()));
    }

    public int prebrojListovi(BNode<Integer> node){
        if (node == null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }

        return prebrojListovi(node.left) + prebrojListovi(node.right);
    }
}
