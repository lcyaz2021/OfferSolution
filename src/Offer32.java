import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author ChenYang Li
 * @Date 2020/3/8 16:33
 * 层序遍历二叉树
 **/
public class Offer32 {
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
        binaryTree.right.left = new BinaryTree(7);
        binaryTree.right.right = new BinaryTree(9);
        print(binaryTree);
        printZ(binaryTree);
    }
    //层序遍历二叉树
    public static void print(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);
        int nextLevel = 0;
        int toBePrint = 1;
        while(!queue.isEmpty()){
            BinaryTree pNode = queue.poll();
            System.out.print(pNode.value + " ");
            if(pNode.left != null){
                queue.add(pNode.left);
                ++nextLevel;
            }
            if(pNode.right != null){
                queue.add(pNode.right);
                ++nextLevel;
            }
            --toBePrint;
            if(toBePrint == 0){
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }
    // 之字形打印二叉树
    public static void printZ(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack[] stacks  = {new Stack<BinaryTree>(),
        new Stack<BinaryTree>()};
        int current = 0;
        int next = 1;
        stacks[current].push(binaryTree);
        while(!stacks[0].empty() || !stacks[1].empty()){
            BinaryTree pNode = (BinaryTree)stacks[current].pop();
            System.out.print(pNode.value + " ");
            if(current == 0){
                if(pNode.left != null){
                    stacks[next].push(pNode.left);
                }
                if(pNode.right != null){
                    stacks[next].push(pNode.right);
                }
            }
            else{
                if(pNode.left != null){
                    stacks[next].push(pNode.right);
                }
                if(pNode.right != null){
                    stacks[next].push(pNode.left);
                }
            }
            if(stacks[current].empty()){
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
