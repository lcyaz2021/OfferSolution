/**
 * 输入某个二叉树的前序遍历和中序遍历的结果，重建该二叉树
 * 前 {1,2,4,7,3,5,6,8}
 * 中 {4,7,2,1,5,3,8,6}
 */

/**
 * 分析：
 * 前序遍历的第一个一定是根节点
 * 所以在前序遍历中取出第一个元素 1
 * 在中序遍历中找到 1
 * 所有在 1 左边的都是他的左子节点(1左下方的点)
 * 所有在 1 右边的都是他的右子节点(1右下方的点)
 * 用 1 分割成左右两块
 * 对接下来的点依此作递归调用即可
 */
public class Offer7 {
    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is,int ie){
        // 开始位置大于结束位置,遍历完成
        if(ps > pe){
            return null;
        }
        // 取前序遍历的第一个节点
        int value = preorder[ps];
        int index = is;
        // 在中序遍历的数组中找到前序第一个节点的位置
        while(index <= ie && inorder[index] != value){
            index++;
        }
        // 判断是否合法,如果index越界证明入参不合法
        if(index > ie){
            throw new RuntimeException("入参不合法");
        }
        // 创建当前根节点,并赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = value;
        // 递归构建左子树,左子树的元素个数为 index - is + 1
        // 左子树对应的前序遍历的位置在[ps + 1,ps + index - is]
        // 左子树对应的中序遍历的位置[is, index - 1]
        node.left = construct(preorder,ps + 1,ps + index - is,inorder,is,index - 1);
        // 递归构建右子树,右子树的元素个数为 ie - index
        // 右子树对应的前序遍历位置在[ps + index - is + 1,pe]
        // 右子树对应的中序遍历的位置在[index + 1,ie]
        node.right = construct(preorder,ps + index - is + 1,pe,inorder,index + 1,ie);
        // 返回创建的根节点信息
        return node;
    }

    // 中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }

    }


    public static void main(String[] args) {
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = construct(a, b);
        printTree(root);
    }
}
