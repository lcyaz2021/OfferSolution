/**
 * @Author ChenYang Li
 * @Date 2020/3/13 15:58
 * 序列化和反序列化二叉树
 **/
public class Offer37 {
    public static int index = -1;
    static class BinaryTree{
        private int value;
        private BinaryTree left;
        private BinaryTree right;
        public BinaryTree(int value){
            this.value = value;
        }
        public BinaryTree(){
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(6);
//        Serialize(tree);
        BinaryTree head = Deserialize("124$$$35$$6$$");
    }

    public static void Serialize(BinaryTree binaryTree){
        if(binaryTree == null){
            System.out.print("$");
            return;
        }
        System.out.print(binaryTree.value);
        Serialize(binaryTree.left);
        Serialize(binaryTree.right);
    }
    public static BinaryTree Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        char[] chars = str.toCharArray();
        BinaryTree node = null;
        if(!(chars[index] == '$')){
            node = new BinaryTree(chars[index] - 48);
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
