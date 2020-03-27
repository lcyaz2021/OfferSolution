/**
 * 输入一个整数
 * 输出其二进制表示中1的个数
 */
public class Offer15 {
    public static void main(String[] args) {
        System.out.println(OneNumber1(9));
    }
    public static int OneNumber(int n){
        int count = 0;
        int flag = 1;
        while(flag > 0){
            if((n & flag) > 0){
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 思路 把一个数减1 与 原数字做运算 就会消除最后面的1
     * 比如1100 -> 1100 & 1011 -> 1000 消除了最后面的 1 ；
     * 1000 -> 1000 & 0111 -> 0000
     * @param n
     * @return
     */
    public static int OneNumber1(int n){
        int count = 0;
        while(n > 0){
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }
}
