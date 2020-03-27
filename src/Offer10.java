/*
斐波那契数列实现

 */
public class Offer10 {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib_for(10));
    }

    /**
     * 斐波那契数列的递归实现
     * @param x
     * @return
     */
    public static int fib(int x){
        if(x == 0 || x == 1) return 1;
        else {
            return fib(x - 1 ) + fib(x - 2);
        }
    }

    /**
     * 斐波那契数列循环解法··
     * @param x
     * @return
     */
    public static int fib_for(int x){
        int[] result = {1,1};
        if(x < 2){
            return result[x];
        }
        int left = 1;
        int right = 1;
        int sum = 0;
        for (int i = 2; i <= x; i++) {
            sum = left + right;
            left = right;
            right = sum;
        }
        return sum;
    }


}
