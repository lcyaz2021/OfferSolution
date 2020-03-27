/**
 * @Author ChenYang Li
 * @Date 2020/3/6 18:06
 * 输入两棵二叉树 判断B是不是A的子结构
 **/
public class Offer26 {
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

        BinaryTree binaryTree2 = new BinaryTree(8);
        binaryTree2.left = new BinaryTree(9);
        binaryTree2.right = new BinaryTree(2);
        System.out.println("HasSubTree(binaryTree,binaryTree2) = " + HasSubTree(binaryTree,binaryTree2));

    }
    public static boolean HasSubTree(BinaryTree pRoot1,BinaryTree pRoot2){
        boolean result = false;
        if(pRoot1 != null && pRoot2 != null){
            if(pRoot1.value == pRoot2.value){
                result = DoesTree1HaveTree2(pRoot1,pRoot2);
            }
            if(!result){
                result = HasSubTree(pRoot1.left,pRoot2);
            }
            if(!result){
                result = HasSubTree(pRoot1.right,pRoot2);
            }
        }
        return result;
    }
    public static boolean DoesTree1HaveTree2(BinaryTree pRoot1,BinaryTree pRoot2){
        if(pRoot2 == null){
            return true;
        }
        if(pRoot1 == null){
            return false;
        }
        if(pRoot1.value != pRoot2.value){
            return false;
        }
        return DoesTree1HaveTree2(pRoot1.left,pRoot2.left) && 
                DoesTree1HaveTree2(pRoot1.right,pRoot2.right);
    }
}
