/**
 * @Author ChenYang Li
 * @Date 2020/3/26 19:45
 * 二叉树的深度
 * 输入一颗二叉树的根节点
 * 求该树的深度
 **/
public class Offer55 {
    static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode b = new BinaryTreeNode(1);
        b.left = new BinaryTreeNode(2);
        b.right = new BinaryTreeNode(3);
        b.right.left = new BinaryTreeNode(4);
        b.right.left.left = new BinaryTreeNode(4);
        System.out.println("treeDeep(b) = " + treeDeep(b));
        System.out.println(isBalance(b));
    }

    /**
     * 递归判断深度
     * @param root
     * @return
     */
    public static int treeDeep(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDeep(root.left);
        int right = treeDeep(root.right);
        return (left > right) ? (left + 1): (right + 1);
    }

    /**
     * 判断一个树 是不是平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalance(BinaryTreeNode root){
        if(root == null){
            return true;
        }
        int left = treeDeep(root.left);
        int right = treeDeep(root.right);
        int dif = left - right;
        if(dif > 1 || dif < -1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
