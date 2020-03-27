/**
 * @Author ChenYang Li
 * @Date 2020/3/13 15:30
 * 二叉搜索树转有序双向链表
 **/
public class Offer36 {
    static class BinaryTree{
        private int value;
        private BinaryTree left;
        private BinaryTree right;
        public BinaryTree(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.left = new BinaryTree(6);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(8);
        tree.right = new BinaryTree(14);
        tree.right.left = new BinaryTree(12);
        tree.right.right = new BinaryTree(16);
        BinaryTree convert = Convert(tree);
        while(convert != null && convert.right != null){
            System.out.println(convert.value);
            convert = convert.right;
        }
        System.out.println(convert.value);
        convert = convert.left;
        while(convert != null){
            System.out.println(convert.value);
            convert = convert.left;
        }
    }
    public static BinaryTree Convert(BinaryTree binaryTree){
        BinaryTree pLastNodeInList = null;
        pLastNodeInList = Convert(binaryTree,pLastNodeInList);
        // 最后一个节点
        BinaryTree pHeadOfList = pLastNodeInList;
        // 找到最开始的节点
        while(pHeadOfList != null && pHeadOfList.left != null){
            pHeadOfList = pHeadOfList.left;
        }
        // 返回最开始的节点
        return pHeadOfList;
    }

    /**
     * 转换核心代码
     * @param binaryTree
     * @param pLastNodeInList
     * @return
     */
    private static BinaryTree Convert(BinaryTree binaryTree, BinaryTree pLastNodeInList) {
        if(binaryTree == null){
            return null;
        }
        BinaryTree pCurrent = binaryTree;
        if(pCurrent.left != null){
            pLastNodeInList = Convert(pCurrent.left,pLastNodeInList);
        }
        pCurrent.left = pLastNodeInList;
        if(pLastNodeInList != null){
            pLastNodeInList.right = pCurrent;
        }
        pLastNodeInList = pCurrent;
        if(pCurrent.right != null){
            pLastNodeInList = Convert(pCurrent.right,pLastNodeInList);
        }
        return pLastNodeInList;
    }
}
