
/**
 * @Author ChenYang Li
 * @Date 2020/3/8 17:09
 * 输入一个数组 判断该数组是不是某二叉搜索树的遍历
 **/
public class Offer33 {
    public static void main(String[] args) {
        int [] a = {5,7,6,9,11,10,8};
        System.out.println("isSearchTree(a) = " + isSearchTree(a,0,a.length-1));
        System.out.println("verifySquenceOfBST(a) = " + verifySquenceOfBST(a));

    }
    public static boolean isSearchTree(int []sequences, int start, int end){
        if(start >= end){
            return true;
        }
        int root = sequences[end];
        int i = 0;
        for (; i < end; i++) {
           if(sequences[i] > root){
               break;
           }
        }
        int j = i;
        for (; j < end; j++) {
            if(sequences[j] < root){
                return false;
            }
        }
        // 判断左右子树是不是二叉搜索树
        boolean left = true;
        if(i > start){
            left = isSearchTree(sequences,start,i - 1);
        }
        boolean right = true;
        if(i < end){
            right = isSearchTree(sequences,i,end - 1);
        }
        return (left && right);
    }
    public static boolean verifySquenceOfBST(int sequence[]){
        if(sequence == null){
            return false;
        }
        return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }
        int root = sequence[end]; //后序遍历的最后一个结点为根结点

        //在二叉搜索树中左子树的结点小于根结点
        int i = 0;
        for(; i < end; ++i){
            if(sequence[i] > root){
                break;
            }
        }

        //在二叉搜索树中右子树的结点大于根结点
        int j = i;
        for(; j < end; ++j){
            if(sequence[j] < root){
                return false;
            }
        }
        //判断左子树是不是二叉树
        boolean left = true;
        if(i > start){
            left = verifySquenceOfBST1(sequence, start, i-1);
        }
        //判断右子树是不是二叉树
        boolean right = true;
        if(i < end){
            right = verifySquenceOfBST1(sequence, i, end -1);
        }
        return (left && right);
    }
}
