/**
 * @Author ChenYang Li
 * @Date 2020/3/26 18:15
 * 二叉搜索树中找出第k小的节点(原题表述有问题)
 *    5
 *  3   7
 * 2 4 6 8
 * 第三小就是 4
 **/
public class Offer54 {
    static class BTree{
        int value;
        BTree left;
        BTree right;
        public BTree(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BTree b = new BTree(5);
        b.left = new BTree(3);
        b.left.left = new BTree(2);
        b.left.right = new BTree(4);
        b.right = new BTree(7);
        b.right.left = new BTree(6);
        b.right.right = new BTree(8);
        System.out.println(kNode(b,3).value);
    }
    public static BTree kNode(BTree bTree,int n){
        if (bTree == null || n <= 0){
            return null;
        }
        return kNodeCore(bTree,n);
    }

    private static BTree kNodeCore(BTree root, int n) {
            if(root != null){ //中序遍历寻找第k个
                BTree node = kNodeCore(root.left,n);
                if(node != null)
                    return node;
                n --;
                if(n == 1)
                    return root;
                node = kNodeCore(root.right,n);
                if(node != null)
                    return node;
            }
            return null;
    }
}
