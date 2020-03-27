/**
 * 长度为n的绳子，剪成m段，每段绳子标记为k0，k1，k2……kn 问从k0到kn可能的最大乘积是多少
 * n = 8 ；
 * 2，3，3 => 2*3*3 = 18
 */
public class Offer14 {
    public static void main(String[] args) {
        System.out.println(MaxProduct(8));
    }
    /**
     * 基础动态规划
     */
    public static int MaxProduct(int n){
        if(n < 2){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int [] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (max < product){
                    max = product;
                    products[i] = max;
                }
            }
        }
        max = products[n];
        return max;
    }
}
