/**
 * @Author ChenYang Li
 * @Date 2020/3/26 20:39
 * 和为s的连续正数序列
 * 输入一个正数s,打印出所有何为s的连续正数序列(至少包含两个数)
 * 例如输入15 -> 1+2+3+4+5=4+5+6=7+8=15 所以打印出三个
 **/
public class Offer57_2 {
    public static void main(String[] args) {
        findSequence(15);
    }
    public static void findSequence(int n){
        if(n <= 2){
            return;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + n) >> 1;
        int curSum = small + big;
        while(small < middle){
            if(curSum == n){
                print(small,big);
            }
            while(curSum > n && small <middle){
                // 对应的是总和大于给定值的情况
                curSum -= small;
                small ++;
                if(curSum == n){
                    print(small,big);
                }
            }
            big ++;
            curSum += big;
        }
    }

    private static void print(int small, int big) {
        for (int i = small; i <= big ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
