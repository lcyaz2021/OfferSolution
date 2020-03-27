/**
 * @Author ChenYang Li
 * @Date 2020/3/7 18:57
 * 判断二叉树是不是对称的
 **/
public class Offer28 {
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
        binaryTree.right = new BinaryTree(8);
        binaryTree.left.left = new BinaryTree(9);
        binaryTree.left.right = new BinaryTree(2);
        binaryTree.right.left = new BinaryTree(2);
        binaryTree.right.right = new BinaryTree(9);
        System.out.println("isSymmetrical(binaryTree) = " + isSymmetrical(binaryTree));
    }

    public static boolean isSymmetrical(BinaryTree binaryTree){
        return isSymmetrical(binaryTree,binaryTree);
    }

    private static boolean isSymmetrical(BinaryTree pRoot1, BinaryTree pRoot2) {
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        else if(pRoot1 == null || pRoot2 == null){
            return false;
        }
        if(pRoot1.value != pRoot2.value){
            return false;
        }
        return isSymmetrical(pRoot1.left,pRoot2.right) &&
                isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
