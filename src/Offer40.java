import java.util.ArrayList;

/**
 * @Author ChenYang Li
 * @Date 2020/3/22 15:16
 * 输入n个整数，找出最小的k个数
 * {4,5,1,6,2,7,3,8} 最小的四个数就是1,2,3,4
 **/
public class Offer40 {
    public static void main(String[] args) {
        int [] a = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = getLeastNumber(a, 4); // 解法1
        for (Integer integer : list) {
            System.out.println(integer);
        }
        ArrayList<Integer> list1 = getLeastNumbers_Solution(a, 4);// 解法2
        for (Integer integer : list1) {
            System.out.println(integer);
        }
    }
    /**
     * 快排思想，部分快排
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumber(int [] input,int k){
        if(input == null || k <= 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>(k);// 新建一个大小为k的列表
        if(k > input.length){
            return list;
        }
        int low = 0;
        int high = input.length - 1;
        int index = partition(input,low,high);
        while(index != k-1){
            if(index > k-1){
                high = index - 1;
            }else{
                low = index + 1;
            }
            index = partition(input,low,high);
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    /**
     * 分区函数
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array,int start,int end){
        int pivot = array[start];
        while(start < end){
            while(start < end && array[end] >= pivot){
                end --;
            }
            array[start] = array[end];
            while(start < end && array[start] <= pivot){
                start ++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    /**
     * 使用最大堆来解决
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int[] numbers=new int[k];  //用于放最小的k个数
        for(int i=0;i<k;i++)
            numbers[i]=input[i];//先放入前k个数
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(numbers,i,k-1);//将数组构造成最大堆形式
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<numbers[0]){ //存在更小的数字时
                numbers[0]=input[i];
                adjustHeap(numbers,0,k-1);//重新调整最大堆
            }
        }
        for(int n:numbers)
            leastNumbers.add(n);
        return leastNumbers;
    }

    //最大堆的调整方法，忘记时可以复习一下堆排序。
    private static void adjustHeap(int[] arr,int start,int end){
        int temp=arr[start];
        int child=start*2+1;
        while(child<=end){
            if(child+1<=end && arr[child+1]>arr[child])
                child++;
            if(arr[child]<temp)
                break;
            arr[start]=arr[child];
            start=child;
            child=child*2+1;
        }
        arr[start]=temp;
    }
}
