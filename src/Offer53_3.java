/**
 * @Author ChenYang Li
 * @Date 2020/3/26 18:18
 * 数组中数值和下标相等的元素
 * 假设一个单调递增的数组里每个元素都是整数且是惟一的
 * 请编写一个函数 寻找任意一个数值等于其下标的元素
 * 例如：{-3,-1,1,3,5}
 * 找出 3
 **/
public class Offer53_3 {
    public static void main(String[] args) {
        int[] a = {-3,-1,1,3,5};
        System.out.println(findEqualNumber(a));
    }

    /**
     * 二分思想
     * @param numbers
     * @return
     */
    public static int findEqualNumber(int[] numbers){
        if (numbers.length <= 0){
            return -1; // 边界值判断
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end){
            int middle = (start + end) >> 1;
            if(numbers[middle] == middle){
                return middle;
            }else if(numbers[middle] > middle){
                // 当前数字比当前下标大 所有当前数字右边的都比它的下标大
                end = middle - 1;
            }else{
                // 左边的都比自己的下标小
                start = middle + 1;
            }
        }
        return -1;
    }
}
