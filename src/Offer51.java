/**
 * @Author ChenYang Li
 * @Date 2020/3/26 10:40
 * 数组中的逆序对
 * 例如{7,5,6,4}
 * 逆序对有(7,6),(7,5),(7,4),(6,4)(5,4)
 **/
public class Offer51 {
    public static void main(String[] args) {
        int [] a = {7,5,6,4};
        System.out.println(findInverse(a));
    }
    public static int findInverse(int[] data){
        if(data.length == 0){
            return 0;
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, copy.length);
        int count = inverseCore(data,copy,0,data.length - 1);
        return count;
    }

    /**
     * 寻找逆序对核心，归并思想
     * @param data
     * @param copy
     * @param start
     * @param end
     * @return
     */
    public static int inverseCore(int[] data, int[] copy, int start, int end) {
        if(start == end){ // 终止条件
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inverseCore(copy, data, start, start + length);
        int right = inverseCore(copy, data, start + length + 1, end);
        int i = start + length; // 初始化为前半段最后一个数字的下标
        int j = end; // 初始化为后半段最后一个数字的下标
        int indexCopy = end;
        int count = 0;
        // 移动的核心部分 两个数组之间的比较 和 copy数组的赋值
        while(i >= start && j >= start + length + 1){
            if (data[i] > data[j]){
                copy[indexCopy--] = data[i--];
                count += (j - start - length);
            }else{
                copy[indexCopy--] = data[j--];
            }
        }
        // 考虑到有一方过大或过小 把剩余的赋值进去
        for(; i >= start; i--){
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length + 1 ;j--){
            copy[indexCopy--] = data[j];
        }
        return left + right + count;
    }
}
