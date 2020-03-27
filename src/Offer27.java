/**
 * @Author ChenYang Li
 * @Date 2020/3/7 18:42
 * 二叉树镜像翻转
 **/
public class Offer27 {
    static class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(8);
        binaryTree.left = new BinaryTree(8);
        binaryTree.right = new BinaryTree(7);
        binaryTree.left.left = new BinaryTree(9);
        binaryTree.left.right = new BinaryTree(2);
        binaryTree.left.right.left = new BinaryTree(4);
        binaryTree.left.right.right = new BinaryTree(7);
        print(binaryTree);
        swopTree(binaryTree);
        print(binaryTree);
    }
    public static void swopTree(BinaryTree binaryTree){
        if(binaryTree == null){
            return ;
        }
        if(binaryTree.left == null && binaryTree.right == null){
            return;
        }
        BinaryTree pTemp = binaryTree.left;// temp
        binaryTree.left = binaryTree.right;
        binaryTree.right = pTemp;
        if(binaryTree.left != null){
            swopTree(binaryTree.left);
        }
        if(binaryTree.right != null){
            swopTree(binaryTree.right);
        }
    }
    public static void print(BinaryTree binaryTree){
        if(binaryTree.left != null){
            print(binaryTree.left);
        }
        System.out.print(binaryTree.value + " ");
        if(binaryTree.right != null){
            print(binaryTree.right);
        }
    }
}
