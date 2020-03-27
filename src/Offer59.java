import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChenYang Li
 * @Date 2020/3/27 9:48
 * 队列中的最大值：
 * 给定数组和一个滑动窗口大小
 * 例如给定{2,3,4,2,6,2,5,1} 和 3
 * 一共有 6 个滑动窗口 他们的最大值分别为{4,4,6,6,6,5}
 **/
public class Offer59 {
    /**
     * 自己实现的双向队列
     */
    static class Queue{
        int [] values;
        int length;
        int nowLength;
        public Queue(int n){
            this.length = n;
            values = new int[n];
            nowLength = 0;
        }
        public boolean hAdd(int item){
            if(nowLength < length){
                // 移位
                for (int i = nowLength; i > 0; i--) {
                    values[i] = values[i-1];
                }
                values[0] = item;
                nowLength ++;
                return true;
            }
            return false;
        }
        public boolean tAdd(int item){
            if(nowLength < length){
                values[nowLength] = item;
                nowLength++;
                return true;
            }
            return false;
        }
        public int tPop(){
            if(nowLength == 0){
                return -1;
            }
            return values[--nowLength];
        }
        public int hPop(){
            if(nowLength == 0){
                return -1;
            }
            int v = values[0];
            // 移位
            nowLength --;
            for (int i = 0; i < nowLength; i++) {
                values[i] = values[i + 1];
            }
            return v;
        }
        public int hGet(){
            if(nowLength == 0){
                return -1;
            }
            return values[0];
        }
        public int tGet(){
            if(nowLength == 0){
                return -1;
            }
            return values[nowLength - 1];
        }
        public void print(){
            for (int i = 0; i < nowLength; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
        public boolean isEmpty(){
            return nowLength == 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        List<Integer> list = maxInWindows(a, 3);
        System.out.println(list);
    }
    public static List<Integer> maxInWindows(int[] numbers,int size){
        ArrayList<Integer> list = new ArrayList<>();
        Queue queue = new Queue(size);
        for (int i = 0; i < size; i++) {
            while(!queue.isEmpty() && numbers[i] >= numbers[queue.tGet()]){
                queue.tPop();
            }
            // 只存数组下标
            queue.tAdd(i);
        }
        for (int i = size; i < numbers.length; i++) {
            list.add(numbers[queue.hGet()]);
            // 判断当前元素是否大于队列中的元素 大于全部移除
            while(!queue.isEmpty() && numbers[i] >= numbers[queue.tGet()]){
                queue.tPop();
            }
            if (!queue.isEmpty() && queue.hGet() <= (i - size)){
                // 必须出队的情况 也就是窗口后移导致最大值 不在窗口大小范围内
                queue.hPop();
            }
            queue.tAdd(i);
        }
        list.add(numbers[queue.hGet()]);
        return list;
    }

}
