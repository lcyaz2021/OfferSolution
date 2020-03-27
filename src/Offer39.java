/**
 * @Author ChenYang Li
 * @Date 2020/3/14 18:09
 * 找出数组中出现超过一半的数字
 **/
public class Offer39 {
    public static void main(String[] args) {
        int[] n = {1,2,3,2,2,2,4,5,2};
        System.out.println("findHalf(n) = " + findHalf(n));
    }

    /**
     * 核心函数
     * @param arr
     * @return
     */
    public static int findHalf(int [] arr){
        if(arr.length <= 0){
            return -1;
        }
        int number = -1;
        int count = 0;
        for (int value : arr) {
            if (count == 0) {
                number = value;
                count = 1;
            } else {
                if (number == value) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        if(check(arr,number)){
            return number;
        }
        return -1;
    }

    /**
     * 检测结果是否正确
     * @param arr
     * @param item
     * @return
     */
    public static boolean check(int[] arr,int item){
        int count = 0;
        for (int i : arr) {
            if(i == item){
                count ++;
            }
        }
        return count > arr.length / 2;
    }
}
