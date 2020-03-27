/**
 * @Author ChenYang Li
 * @Date 2020/3/3 10:52
 * 实现函数 double Power(double base,int exponent) 求base 的 exponent次方。不得使用库函数
 **/
public class Offer16 {
    public static void main(String[] args) {
        System.out.println("Power(2,-2) = " + Power(2, -2));
        System.out.println("Power(2,2) = " + Power(2, 2));
        System.out.println("Power(-2,-2) = " + Power(-2, -2));
        System.out.println("Power(0,-2) = " + Power(0, 2));
        System.out.println("Power(2,) = " + Power(2, 0));
    }

    /**
     * 基础解法
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        boolean minus = false;
        if (exponent < 0) {
            minus = true;
            exponent = -exponent;
        }
        if (base == 0.0) {
            return 0.0;
        }
//        double result = 1.0; // 基本解法
//        for (int i = 1; i <= exponent; i++) {
//            result *= base;
//        }
        double result = Power2(base, exponent);  // 优化解法
        return minus ? 1 / result : result;
    }

    /**
     * 利用公式 a^n = a^(n/2) * a^(n/2)
     * a^n = a^((n-1)/2) * a^((n-1)/2) * a
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        double result = Power2(base, exponent >> 1); // 除以二
        result *= result;
        if ((exponent & 1) == 1) {  // 与运算 判断余数是不是1
            result *= base;
        }
        return result;
    }
}
