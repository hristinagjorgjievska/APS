package BinarniPrebaruvackiDrva;

public class VisinaNaDrvo {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(0);

        VisinaNaDrvo visina = new VisinaNaDrvo();
        System.out.println(visina.visina(tree.getRoot()));
    }

    public int visina(BNode<Integer> node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(visina(node.left), visina(node.right));
    }
}
