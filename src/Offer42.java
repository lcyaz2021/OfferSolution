/**
 * @Author ChenYang Li
 * @Date 2020/3/22 16:10
 * 连续子数组的最大和
 * 输入一个整数数组,数组里有正数也有负数。求所有子数组的和的最大值。要求时间复杂度O(n)
 * {1,-2,3,10,-4,7,2,-5} -> {3,10,-4,7,2} = 18
 **/
public class Offer42 {
    static boolean isError = false;
    public static void main(String[] args) {
        int [] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSum(a));
        System.out.println(dg(a));
    }
    public static int findGreatestSum(int[] arr){
        if(arr.length == 0){
            isError = true;
            return 0;
        }
        isError = false;
        int sum = 0;
        int greatSum = 0x80000000; // 初始化成最小值
        for (int value : arr) {
            if (sum <= 0) {
                sum = value;
            } else {
                sum += value;
            }
            if (sum > greatSum) {
                greatSum = sum;
            }
        }
        return greatSum;
    }

    /**
     * 动态规划
     * @param arr
     * @return
     */
    public static int dg(int[] arr){
        int [] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(res[i - 1] < 0){
                res[i] = arr[i];
            }else{
                res[i] = res[i - 1] + arr[i];
            }
        }
        int max = 0x80000000;
        for (int r : res) {
            if(r > max){
                max = r;
            }
        }
        return max;
    }
}
