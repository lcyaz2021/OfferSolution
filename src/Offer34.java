import java.util.Stack;

/**
 * @Author ChenYang Li
 * @Date 2020/3/9 11:24
 * 寻找二叉树中路径和等于某个值的路径
 **/
public class Offer34 {
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
        binaryTree.left = new BinaryTree(6);
        binaryTree.right = new BinaryTree(8);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(8);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(9);
        findPath(binaryTree,22);
    }
    public static void findPath(BinaryTree binaryTree,int sum){
        if(binaryTree == null){
            return;
        }
        Stack<Integer> path = new Stack<>();
        int nowSum = 0;
        findPath(binaryTree,sum,path,nowSum);
    }

    private static void findPath(BinaryTree binaryTree, int sum, Stack<Integer> path, int nowSum) {
        nowSum += binaryTree.value;
//        System.out.println("nowSum = " + nowSum);
        path.push(binaryTree.value);
        // 如果是叶子节点 且路径上节点值得和等于输入得值
        boolean isLeaf = (binaryTree.left == null && binaryTree.right == null);
        if(nowSum == sum && isLeaf){
            System.out.println("Path:");
            int [] temp = new int[path.size()];
            int i = 0;
            while(i < path.size()){
                temp[i] = path.get(i);
                i++;
            }
            for (i = 0; i < path.size(); i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
        }
        // 不是叶子节点
        if(binaryTree.left != null){
            findPath(binaryTree.left,sum,path,nowSum);
        }
        if(binaryTree.right != null){
            findPath(binaryTree.right,sum,path,nowSum);
        }
        // 弹出本节点
        path.pop();
    }
}
