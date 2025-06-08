package BinarniPrebaruvackiDrva;

public class PrebrojJazliSoEdnoDete {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(14);

        PrebrojJazliSoEdnoDete tmp = new PrebrojJazliSoEdnoDete();
        System.out.println(tmp.prebrojDeca(tree.getRoot()));
    }

    public int prebrojDeca(BNode<Integer> node){
        if (node == null){
            return 0;
        }
        //ako nema desno ili levo dete znaci ima 1 dete
        if ((node.right == null && node.left != null) || (node.right != null && node.left == null)){
            return 1 + prebrojDeca(node.right) + prebrojDeca(node.left);
        }

        return prebrojDeca(node.right) + prebrojDeca(node.left);
    }
}
