/**
 * @Author ChenYang Li
 * @Date 2020/3/4 11:04
 * 给定一个数组 要求将奇数全部移动到偶数前面
 **/
public class Offer21 {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int[] move = move(a);
        for (int i : move) {
            System.out.println(i);
        }
    }

    /**
     * 两个变量 一个从后往前 只找奇数
     * 一个从前往后 只找偶数
     * @param data
     * @return
     */
    public static int[] move(int[] data){
        if(data.length == 0) return null;
        int begin = 0;
        int end = data.length - 1;
        while(begin < end){
            // 向后移动begin 直到指向偶数
            while(begin < end && (data[begin] & 1) != 0){
                begin++;
            }
            // 向前移动end 直到指向奇数
            while(begin < end && (data[end] &1 ) == 0){
                end--;
            }
            // 交换位置
            if(begin < end){
                int temp = data[begin];
                data[begin] = data[end];
                data[end] = temp;
            }
        }
        return data;
    }
}
