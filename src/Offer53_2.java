/**
 * @Author ChenYang Li
 * @Date 2020/3/26 15:43
 * 53-2 0~n-1 缺失的数字
 * 一个长度为n-1的递增排序数组中所有数字都是唯一的，并且每个数字都在范围0~n-1之内，在范围0~n-1有且仅有一个数字
 * 不在该数组中，请找出
 **/
public class Offer53_2 {
    public static void main(String[] args) {
        int [] a = {0,1,2,3,4,5,6,7,9,10};
        System.out.println(getOnlyNumber(a));
    }

    /**
     * 改进的二分算法
     * @param numbers
     * @return
     */
    public static int getOnlyNumber(int[] numbers){
        if(numbers.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        while(start <= end){
            int middle = (start + end) >> 1; // 加快运算速度
            if(numbers[middle] != middle){
                if(middle == 0 || numbers[middle - 1] == middle - 1){
                    return middle;
                }
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        if(start == numbers.length){
            return numbers.length;
        }
        return -1;
    }
}
