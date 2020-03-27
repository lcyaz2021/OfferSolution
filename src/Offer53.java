/**
 * @Author ChenYang Li
 * @Date 2020/3/26 15:05
 * 统计一个数字在一个已排序数组中出现的次数
 * 例如输入{1,2,3,3,3,3,4,5} 和 数字 3
 **/
public class Offer53 {
    public static void main(String[] args) {
        int [] a =  {1,2,3,3,3,3,4,5};
        System.out.println(getNumber_1(a,3));
        System.out.println(getNumber_2(a,3));
    }

    /**
     * 基础二分解法 大量重复的数据时间复杂度较高
     * @param numbers
     * @param key
     * @return
     */
    public static int getNumber_1(int [] numbers,int key){
        int index = halfFind(numbers,0,numbers.length - 1,key);
        int count = 0;
        for (int i = index;i<numbers.length;i++){
            if(numbers[i] == key){
                count ++;
            }else{
                break;
            }
        }
        for (int i = index;i>0;i--){
            if(numbers[i] == key){
                count ++;
            }else{
                break;
            }
        }
        return count - 1;
    }
    public static int halfFind(int []numbers,int start,int end,int key){
        if(start > end){
            return -1;
        }
        int middle = (start + end) / 2;
        if(numbers[middle] == key){
            return middle;
        }
        if(numbers[middle] < key){
            start = middle + 1;
        }else{
            end = middle - 1;
        }
        return halfFind(numbers, start, end, key);
    }

    /**
     * 改进二分 利用两次二分查找 直接找到第一个key 和 最后一个key 时间复杂度降低
     * @param numbers
     * @param key
     * @return
     */
    public static int getNumber_2(int [] numbers,int key){
        int first = getFirstKey(numbers,0,numbers.length - 1,key);
        int last = getLastKey(numbers,0,numbers.length - 1,key);
        if(first > -1 && last > -1){
            return last - first + 1;
        }
        System.out.println(first);
        System.out.println(last);
        return -1;
    }

    /**
     * 获取最后一个key
     * @param numbers
     * @param start
     * @param end
     * @param key
     * @return
     */
    private static int getLastKey(int[] numbers, int start, int end, int key) {
        if(start > end){
            return -1;
        }
        int middle = (start + end) / 2;
        if(numbers[middle] == key){
            if((middle < numbers.length - 1 && numbers[middle + 1] != key)|| middle == numbers.length - 1){
                return middle;
            }else{
                start = middle + 1;
            }
        }
        else if(numbers[middle] < key){
            start = middle + 1;
        }else{
            end = middle - 1;
        }
        return getLastKey(numbers, start, end, key);
    }

    /**
     * 获取第一个key
     * @param numbers
     * @param start
     * @param end
     * @param key
     * @return
     */
    private static int getFirstKey(int[] numbers, int start, int end, int key) {
        if(start > end){
            return -1;
        }
        int middle = (start + end) / 2;
        if(numbers[middle] == key){
            if((middle > 0 && numbers[middle - 1] != key)|| middle == 0){
                return middle;
            }else{
                end = middle - 1;
            }
        }
        else if(numbers[middle] < key){
            start = middle + 1;
        }else{
            end = middle - 1;
        }
        return getFirstKey(numbers, start, end, key);
    }
}
